package com.flz.dt.order.domain.repository;

import com.flz.dt.order.domain.aggregate.Order;
import com.flz.dt.order.infrastructure.converter.OrderDetailEntityConverter;
import com.flz.dt.order.infrastructure.converter.OrderEntityConverter;
import com.flz.dt.order.infrastructure.dataobject.OrderDO;
import com.flz.dt.order.infrastructure.dataobject.OrderDetailDO;
import com.flz.dt.order.infrastructure.repository.OrderDetailJDBCRepository;
import com.flz.dt.order.infrastructure.repository.OrderJDBCRepository;
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
        OrderDO orderEntity = orderEntityConverter.toEntity(order);
        List<OrderDetailDO> orderDetailEntities = orderDetailEntityConverter.toEntities(order.getDetails());
        orderJDBCRepository.save(orderEntity);
        orderDetailJDBCRepository.saveAll(orderDetailEntities);
    }
}
