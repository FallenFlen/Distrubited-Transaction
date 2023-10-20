package com.flz.dt.order.application.service.localevent.handler;

import com.flz.dt.order.domain.aggregate.LocalEvent;
import com.flz.dt.order.domain.enums.LocalEventType;

public interface LocalEventHandler {
    void handle(LocalEvent localEvent);

    LocalEventType getSupportType();
}
