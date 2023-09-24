package com.flz.dt.order.application.service;

import com.flz.dt.common.context.UserContext;
import com.flz.dt.order.application.client.FinanceClient;
import com.flz.dt.order.application.client.StorageClient;
import com.flz.dt.order.domain.aggregate.Order;
import com.flz.dt.order.domain.command.OrderCreateCommand;
import com.flz.dt.order.domain.repository.OrderDomainRepository;
import com.flz.dt.order.presentation.converter.OrderDTOConverter;
import com.flz.dt.order.presentation.dto.OrderCreateRequestDTO;
import com.flz.finance.dto.request.UserCreditChangeRequestDTO;
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

        // 库存模块扣减商品库存
        changeStorage(requestDTO.getDetails());

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
        financeClient.changeUserCredit(userCreditChangeRequestDTO);
    }
}
