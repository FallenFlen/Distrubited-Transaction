package com.flz.dt.order.application.service.localevent.handler;

import com.flz.dt.order.domain.aggregate.LocalEvent;
import com.flz.dt.order.domain.enums.LocalEventType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FinanceRollbackCreditLocalEventHandler implements LocalEventHandler {
    @Override
    public void handle(LocalEvent localEvent) {

    }

    @Override
    public LocalEventType getSupportType() {
        return null;
    }
}
