package com.flz.dt.order.application.service.localevent.config;

import com.flz.dt.order.application.service.localevent.LocalEventCollection;
import com.flz.dt.order.application.service.localevent.handler.FinanceRollbackCreditLocalEventHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class LocalEventHandlerConfig {
    private final ApplicationContext applicationContext;

    @Bean
    public LocalEventCollection localEventCollection() {
        LocalEventCollection localEventCollection = new LocalEventCollection();
        localEventCollection.init(
                applicationContext.getBean(FinanceRollbackCreditLocalEventHandler.class)
        );
        return localEventCollection;
    }
}
