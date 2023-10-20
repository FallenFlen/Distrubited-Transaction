package com.flz.dt.order.application.service;

import com.flz.dt.order.application.service.localevent.LocalEventService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ScheduleService {
    private final LocalEventService localEventService;

    @Scheduled(cron = "0 0/3 * * * ?")
    public void scanLocalEvents(){
        localEventService.handleLocalEvents();
    }
}
