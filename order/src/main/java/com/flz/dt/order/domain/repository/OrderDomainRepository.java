package com.flz.dt.order.domain.repository;

import com.flz.dt.order.domain.aggregate.Order;
import com.flz.dt.order.persist.converter.OrderDetailEntityConverter;
import com.flz.dt.order.persist.converter.OrderEntityConverter;
import com.flz.dt.order.persist.entity.OrderDetailEntity;
import com.flz.dt.order.persist.entity.OrderEntity;
import com.flz.dt.order.persist.repository.OrderDetailJDBCRepository;
import com.flz.dt.order.persist.repository.OrderJDBCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderDomainRepository {
    private final OrderJDBCRepository orderJDBCRepository;
    private final OrderDetailJDBCRepository orderDetailJDBCRepository;
    private final OrderEntityConverter orderEntityConverter = OrderEntityConverter.INSTANCE;
    private final OrderDetailEntityConverter orderDetailEntityConverter = OrderDetailEntityConverter.INSTANCE;

    public void save(Order order) {
        OrderEntity orderEntity = orderEntityConverter.toEntity(order);
        List<OrderDetailEntity> orderDetailEntities = orderDetailEntityConverter.toEntities(order.getDetails());
        orderJDBCRepository.save(orderEntity);
        orderDetailJDBCRepository.saveAll(orderDetailEntities);
    }
}
