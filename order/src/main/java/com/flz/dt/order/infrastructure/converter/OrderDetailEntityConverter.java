package com.flz.dt.order.infrastructure.converter;

import com.flz.dt.order.domain.aggregate.OrderDetail;
import com.flz.dt.order.infrastructure.dataobject.OrderDetailDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderDetailEntityConverter {
    OrderDetailEntityConverter INSTANCE = Mappers.getMapper(OrderDetailEntityConverter.class);

    OrderDetailDO toEntity(OrderDetail orderDetail);

    List<OrderDetailDO> toEntities(List<OrderDetail> orderDetails);
}
