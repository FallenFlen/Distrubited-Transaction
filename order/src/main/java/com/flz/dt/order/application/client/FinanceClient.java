package com.flz.dt.order.application.client;

import com.flz.dt.order.infrastructure.client.FinanceFeignClient;
import com.flz.finance.dto.request.UserCreditChangeRequestDTO;
import com.flz.finance.dto.response.FinanceInfoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FinanceClient {
    private final FinanceFeignClient financeFeignClient;

    public void changeUserCredit(UserCreditChangeRequestDTO requestDTO) {
        financeFeignClient.changeUserCredit(requestDTO);
    }

    public FinanceInfoResponseDTO fetchFinanceInfo(String userId) {
        return financeFeignClient.fetchFinanceInfo(userId);
    }
}
