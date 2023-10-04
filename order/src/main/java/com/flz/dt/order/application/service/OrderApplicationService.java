package com.flz.dt.order.application.service;

import com.flz.dt.common.context.UserContext;
import com.flz.dt.common.exception.BusinessException;
import com.flz.dt.common.utils.UUIDUtils;
import com.flz.dt.order.application.client.FinanceClient;
import com.flz.dt.order.application.client.StorageClient;
import com.flz.dt.order.domain.aggregate.Order;
import com.flz.dt.order.domain.command.OrderCreateCommand;
import com.flz.dt.order.domain.repository.OrderDomainRepository;
import com.flz.dt.order.presentation.converter.OrderDTOConverter;
import com.flz.dt.order.presentation.dto.OrderCreateRequestDTO;
import com.flz.dt.order.presentation.dto.PurchaseSummaryResponseDTO;
import com.flz.finance.dto.enums.UserCreditChangeAction;
import com.flz.finance.dto.request.UserCreditChangeRequestDTO;
import com.flz.finance.dto.response.FinanceInfoResponseDTO;
import com.flz.storage.dto.StorageChangeRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderApplicationService {
    private final OrderDomainRepository orderDomainRepository;
    private final FinanceClient financeClient;
    private final StorageClient storageClient;
    private final OrderDTOConverter converter = OrderDTOConverter.INSTANCE;

    @Transactional
    public void createOrder(OrderCreateRequestDTO requestDTO) {
        OrderCreateCommand command = converter.toCommand(requestDTO);
        Order order = Order.create(command);

        // 财务模块扣减额度
        String userId = UserContext.getUser().getId();
        changeCredit(order.getTotalPrice(), userId);
        if (Boolean.TRUE.equals(requestDTO.getTriggerStage1Exception())) {
            throw new BusinessException("exception occurred after credit changed");
        }
        // 库存模块扣减商品库存
        changeStorage(requestDTO.getDetails());
        if (Boolean.TRUE.equals(requestDTO.getTriggerStage2Exception())) {
            throw new BusinessException("exception occurred after credit and storage changed");
        }
        // 保存订单
        orderDomainRepository.save(order);
    }

    private void changeStorage(List<OrderCreateRequestDTO.OrderDetailCreateRequestDTO> details) {
        StorageChangeRequestDTO storageChangeRequestDTO = new StorageChangeRequestDTO();
        List<StorageChangeRequestDTO.SkuStorage> skuStorages = details.stream()
                .map(it -> new StorageChangeRequestDTO.SkuStorage(it.getSkuId(), -it.getCount()))
                .collect(Collectors.toList());
        storageChangeRequestDTO.setSkuStorages(skuStorages);
        storageClient.batchChangeStorage(storageChangeRequestDTO);
    }

    private void changeCredit(BigDecimal totalPrice, String userId) {
        UserCreditChangeRequestDTO userCreditChangeRequestDTO = new UserCreditChangeRequestDTO();
        userCreditChangeRequestDTO.setUserId(userId);
        userCreditChangeRequestDTO.setAmount(totalPrice.negate());
        userCreditChangeRequestDTO.setAction(UserCreditChangeAction.CHANGE);
        userCreditChangeRequestDTO.setTransactionId(UUIDUtils.uuid32());
        financeClient.changeUserCredit(userCreditChangeRequestDTO);
    }

    public PurchaseSummaryResponseDTO fetchPurchaseSummary(String userId, List<String> skuIds) {
        PurchaseSummaryResponseDTO purchaseSummaryResponseDTO = new PurchaseSummaryResponseDTO();
        purchaseSummaryResponseDTO.setFinanceInfo(fetchFinanceInfo(userId));
        purchaseSummaryResponseDTO.setStorageInfos(fetchStorageInfos(skuIds));
        return purchaseSummaryResponseDTO;
    }

    private PurchaseSummaryResponseDTO.FinanceInfo fetchFinanceInfo(String userId) {
        FinanceInfoResponseDTO financeInfoResponseDTO = financeClient.fetchFinanceInfo(userId);
        return new PurchaseSummaryResponseDTO.FinanceInfo(financeInfoResponseDTO.getUserId(), financeInfoResponseDTO.getCredit());
    }

    private List<PurchaseSummaryResponseDTO.StorageInfo> fetchStorageInfos(List<String> skuIds) {
        return storageClient.fetchStorageInfo(skuIds).stream()
                .map(it -> new PurchaseSummaryResponseDTO.StorageInfo(it.getSkuId(), it.getSkuName(), it.getStorage()))
                .collect(Collectors.toList());
    }
}
