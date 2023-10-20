package com.flz.dt.order.infrastructure.converter;

import com.flz.dt.order.domain.aggregate.LocalEvent;
import com.flz.dt.order.infrastructure.dataobject.LocalEventDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface LocalEventEntityConverter {
    LocalEventEntityConverter INSTANCE = Mappers.getMapper(LocalEventEntityConverter.class);

    LocalEvent toDomain(LocalEventDO localEventEntity);

    LocalEventDO toEntity(LocalEvent localEvent);
}
