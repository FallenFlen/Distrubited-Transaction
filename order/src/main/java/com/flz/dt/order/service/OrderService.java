package com.flz.dt.order.service;

import com.flz.dt.order.command.OrderCreateCommand;
import com.flz.dt.order.controller.converter.OrderDTOConverter;
import com.flz.dt.order.domain.aggregate.Order;
import com.flz.dt.order.domain.repository.OrderDomainRepository;
import com.flz.dt.order.dto.OrderCreateRequestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderDomainRepository orderDomainRepository;
    private final OrderDTOConverter converter = OrderDTOConverter.INSTANCE;

    @Transactional
    public void createOrder(OrderCreateRequestDTO requestDTO) {
        // 创建并保存订单
        OrderCreateCommand command = converter.toCommand(requestDTO);
        Order order = Order.create(command);
        orderDomainRepository.save(order);

        // 财务模块扣减额度

        // 库存模块扣减商品库存
    }
}
