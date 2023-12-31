package com.flz.dt.order.presentation.converter;

import com.flz.dt.order.domain.command.OrderCreateCommand;
import com.flz.dt.order.presentation.dto.OrderCreateRequestDTO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderDTOConverter {
    OrderDTOConverter INSTANCE = Mappers.getMapper(OrderDTOConverter.class);

    OrderCreateCommand toCommand(OrderCreateRequestDTO requestDTO);
}
