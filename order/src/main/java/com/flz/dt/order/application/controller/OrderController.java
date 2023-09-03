package com.flz.dt.order.application.controller;

import com.flz.dt.order.application.controller.dto.OrderCreateRequestDTO;
import com.flz.dt.order.application.service.OrderApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderApplicationService orderApplicationService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createOrder(@RequestBody @Validated OrderCreateRequestDTO requestDTO) {
        orderApplicationService.createOrder(requestDTO);
    }
}
