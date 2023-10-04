package com.flz.dt.order.presentation.controller;

import com.flz.dt.order.application.service.OrderApplicationService;
import com.flz.dt.order.presentation.dto.OrderCreateRequestDTO;
import com.flz.dt.order.presentation.dto.PurchaseSummaryResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderApplicationService orderApplicationService;

    @GetMapping("/purchase/summary")
    public PurchaseSummaryResponseDTO fetchPurchaseSummary(@RequestParam String userId, @RequestParam List<String> skuIds) {
        return orderApplicationService.fetchPurchaseSummary(userId, skuIds);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void createOrder(@RequestBody @Validated OrderCreateRequestDTO requestDTO) {
        orderApplicationService.createOrder(requestDTO);
    }
}
