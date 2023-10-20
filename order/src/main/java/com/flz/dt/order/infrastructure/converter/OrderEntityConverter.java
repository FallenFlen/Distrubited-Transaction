package com.flz.dt.order.infrastructure.converter;

import com.flz.dt.order.domain.aggregate.Order;
import com.flz.dt.order.infrastructure.dataobject.OrderDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderEntityConverter {
    OrderEntityConverter INSTANCE = Mappers.getMapper(OrderEntityConverter.class);

    OrderDO toEntity(Order order);
}
