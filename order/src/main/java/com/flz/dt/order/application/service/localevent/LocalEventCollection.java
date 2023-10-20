package com.flz.dt.order.application.service.localevent;

import com.flz.dt.order.application.service.localevent.handler.LocalEventHandler;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class LocalEventCollection {
    private List<LocalEventHandler> localEventHandlers;

    public void init(LocalEventHandler... handlers) {
        this.localEventHandlers = Arrays.asList(handlers);
    }
}
