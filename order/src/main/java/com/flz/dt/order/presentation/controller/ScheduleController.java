package com.flz.dt.order.presentation.controller;

import com.flz.dt.order.application.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/inner/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    @PostMapping("/scan-local-events")
    public void scanLocalEvents() {
        scheduleService.scanLocalEvents();
    }
}
