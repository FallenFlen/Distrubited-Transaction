package com.flz.dt.order.domain.aggregate;

import com.flz.dt.common.context.UserContext;
import com.flz.dt.common.domain.DomainAggregateRoot;
import com.flz.dt.order.domain.command.OrderCreateCommand;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Builder
public class OrderDetail extends DomainAggregateRoot {
    private String orderId;
    private String skuId;
    private String skuName;
    private Long count;
    private BigDecimal price;

    public static OrderDetail create(String orderId, OrderCreateCommand.OrderDetailCreateCommand command) {
        OrderDetail detail = OrderDetail.builder()
                .orderId(orderId)
                .skuId(command.getSkuId())
                .skuName(command.getSkuName())
                .count(command.getCount())
                .price(command.getPrice())
                .build();
        detail.generateId();
        detail.createBy(UserContext.getUser().getName());
        return detail;
    }
}
