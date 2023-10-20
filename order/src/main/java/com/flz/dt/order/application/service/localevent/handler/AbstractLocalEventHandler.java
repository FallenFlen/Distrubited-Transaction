package com.flz.dt.order.application.service.localevent.handler;

import com.flz.dt.order.domain.aggregate.LocalEvent;
import com.flz.dt.order.domain.repository.LocalEventDomainRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.util.List;

@Slf4j
public abstract class AbstractLocalEventHandler implements LocalEventHandler {
    @Autowired
    protected LocalEventDomainRepository localEventDomainRepository;
    @Value("${local-event.max-retry:5}")
    protected int maxRetryTime;

    @Override
    public void handle(LocalEvent localEvent) {
        // body->request->feign call
        // success->mark it
        // failed->mart it->retry
        // finally save event
        try {
            doHandle(localEvent);
            log.info("local event[{}] handle successfully", getSupportType());
            localEvent.success();
        } catch (Throwable throwable) {
            log.error("local event[{}] failed and start retry with exception:", getSupportType(), throwable);
            localEvent.fail(maxRetryTime);
        } finally {
            log.info("local event[{}] handle finished", getSupportType());
            localEventDomainRepository.saveAll(List.of(localEvent));
        }

    }

    protected abstract void doHandle(LocalEvent localEvent);

}
