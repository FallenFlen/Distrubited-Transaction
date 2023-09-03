package com.flz.dt.order.persist.converter;

import com.flz.dt.order.domain.aggregate.Order;
import com.flz.dt.order.persist.entity.OrderEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderEntityConverter {
    OrderEntityConverter INSTANCE = Mappers.getMapper(OrderEntityConverter.class);

    OrderEntity toEntity(Order order);
}
