package com.flz.dt.order.application.service.localevent;

import com.flz.dt.order.application.service.localevent.handler.LocalEventHandler;
import com.flz.dt.order.common.utils.TransactionUtils;
import com.flz.dt.order.domain.aggregate.LocalEvent;
import com.flz.dt.order.domain.enums.LocalEventStatus;
import com.flz.dt.order.domain.enums.LocalEventType;
import com.flz.dt.order.domain.repository.LocalEventDomainRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Slf4j
@Service
@RequiredArgsConstructor
public class LocalEventService {
    private final LocalEventDomainRepository localEventDomainRepository;
    private final LocalEventCollection localEventCollection;
    private final TransactionUtils transactionUtils;

    public void handleLocalEvents() {
        List<LocalEvent> localEvents = localEventDomainRepository.findAllByStatusIn(LocalEventStatus.pendingProcessedStatus());
        if (localEvents.isEmpty()) {
            log.info("no pending processed event found");
            return;
        }

        log.info("{} events found, start processing", localEvents.size());
        Set<LocalEventType> eventTypes = new HashSet<>();
        List<LocalEventHandler> localEventHandlers = localEventCollection.getLocalEventHandlers();
        localEventHandlers.stream()
                .filter(handler -> eventTypes.add(handler.getSupportType()))
                .forEach(handler -> {
                    transactionUtils.runInNewTransaction(() -> {
                        localEvents.stream()
                                .filter(event -> event.getType() == handler.getSupportType())
                                .forEach(handler::handle);
                    });
                });
    }
}
