package com.flz.dt.order.application.service.localevent;

import com.flz.dt.order.application.service.localevent.handler.LocalEventHandler;
import com.flz.dt.order.domain.aggregate.LocalEvent;
import com.flz.dt.order.domain.enums.LocalEventStatus;
import com.flz.dt.order.domain.repository.LocalEventDomainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocalEventService {
    private final LocalEventDomainRepository localEventDomainRepository;
    private final List<LocalEventHandler> localEventHandlers;

    @Transactional
    public void handleLocalEvents() {
        List<LocalEvent> localEvents = localEventDomainRepository.findAllByStatusIn(LocalEventStatus.pendingProcessedStatus());
        if (localEvents.isEmpty()) {
            log.info("no pending processed event found");
            return;
        }

        localEventHandlers.forEach(handler -> {
            localEvents.stream()
                    .filter(event -> event.getType() == handler.getSupportType())
                    .forEach(handler::handle);
        });
    }
}
