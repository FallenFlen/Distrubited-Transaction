package com.flz.dt.order.domain.repository;

import com.flz.dt.order.domain.aggregate.Order;
import com.flz.dt.order.infrastructure.converter.OrderDOConverter;
import com.flz.dt.order.infrastructure.converter.OrderDetailDOConverter;
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
    private final OrderDOConverter orderDOConverter = OrderDOConverter.INSTANCE;
    private final OrderDetailDOConverter orderDetailDOConverter = OrderDetailDOConverter.INSTANCE;

    public void save(Order order) {
        OrderDO orderEntity = orderDOConverter.toDO(order);
        List<OrderDetailDO> orderDetailEntities = orderDetailDOConverter.toDOs(order.getDetails());
        orderJDBCRepository.save(orderEntity);
        orderDetailJDBCRepository.saveAll(orderDetailEntities);
    }
}
