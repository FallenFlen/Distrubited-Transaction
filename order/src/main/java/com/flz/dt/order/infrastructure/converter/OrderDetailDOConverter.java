package com.flz.dt.order.infrastructure.converter;

import com.flz.dt.order.domain.aggregate.OrderDetail;
import com.flz.dt.order.infrastructure.dataobject.OrderDetailDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderDetailDOConverter {
    OrderDetailDOConverter INSTANCE = Mappers.getMapper(OrderDetailDOConverter.class);

    OrderDetailDO toDO(OrderDetail orderDetail);

    List<OrderDetailDO> toDOs(List<OrderDetail> orderDetails);
}
