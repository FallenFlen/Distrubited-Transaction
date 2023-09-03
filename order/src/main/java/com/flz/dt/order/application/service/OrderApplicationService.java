package com.flz.dt.order.application.service;

import com.flz.dt.order.application.controller.dto.OrderCreateRequestDTO;
import com.flz.dt.order.domain.aggregate.Order;
import com.flz.dt.order.domain.repository.OrderDomainRepository;
import com.flz.dt.order.domain.service.OrderDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class OrderApplicationService {
    private final OrderDomainRepository orderDomainRepository;
    private final OrderDomainService orderDomainService;

    @Transactional
    public void createOrder(OrderCreateRequestDTO requestDTO) {
        // 创建并保存订单
        Order order = orderDomainService.createOrder(requestDTO);
        orderDomainRepository.save(order);

        // 财务模块扣减额度

        // 库存模块扣减商品库存
    }
}
