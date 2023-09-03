package com.flz.dt.order.domain.service;

import com.flz.dt.order.application.controller.converter.OrderDTOConverter;
import com.flz.dt.order.application.controller.dto.OrderCreateRequestDTO;
import com.flz.dt.order.domain.aggregate.Order;
import com.flz.dt.order.domain.command.OrderCreateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderDomainService {
    private final OrderDTOConverter converter = OrderDTOConverter.INSTANCE;

    public Order createOrder(OrderCreateRequestDTO requestDTO) {
        OrderCreateCommand command = converter.toCommand(requestDTO);
        return Order.create(command);
    }
}
