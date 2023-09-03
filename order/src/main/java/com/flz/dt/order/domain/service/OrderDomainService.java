package com.flz.dt.order.domain.service;

import com.flz.dt.order.domain.aggregate.Order;
import com.flz.dt.order.domain.command.OrderCreateCommand;
import com.flz.dt.order.presentation.converter.OrderDTOConverter;
import com.flz.dt.order.presentation.dto.OrderCreateRequestDTO;
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
