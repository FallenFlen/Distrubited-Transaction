package com.flz.dt.order.application.service.localevent.handler;

import com.fasterxml.jackson.core.type.TypeReference;
import com.flz.dt.common.utils.JsonUtils;
import com.flz.dt.order.application.client.FinanceClient;
import com.flz.dt.order.domain.aggregate.LocalEvent;
import com.flz.dt.order.domain.enums.LocalEventType;
import com.flz.finance.dto.request.UserCreditChangeRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FinanceRollbackCreditLocalEventHandler extends AbstractLocalEventHandler {
    private final FinanceClient financeClient;

    @Override
    public LocalEventType getSupportType() {
        return LocalEventType.FINANCE_CREDIT_ROLLBACK;
    }

    @Override
    protected void doHandle(LocalEvent localEvent) {
        UserCreditChangeRequestDTO requestDTO = JsonUtils.silentUnMarshal(localEvent.getBody(), new TypeReference<>() {
        });
        financeClient.changeUserCredit(requestDTO);
    }
}
