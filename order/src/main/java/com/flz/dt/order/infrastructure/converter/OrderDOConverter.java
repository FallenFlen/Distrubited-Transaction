package com.flz.dt.order.infrastructure.converter;

import com.flz.dt.order.domain.aggregate.Order;
import com.flz.dt.order.infrastructure.dataobject.OrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderDOConverter {
    OrderDOConverter INSTANCE = Mappers.getMapper(OrderDOConverter.class);

    OrderDO toDO(Order order);
}
