package com.flz.dt.order.domain.aggregate;

import com.flz.dt.common.context.User;
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
import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Builder
public class Order extends DomainAggregateRoot {
    private String userId;
    private String description;
    private BigDecimal totalPrice;
    private List<OrderDetail> details;

    public static Order create(OrderCreateCommand command) {
        User user = UserContext.getUser();
        Order order = Order.builder()
                .userId(user.getId())
                .description(command.getDescription())
                .build();
        order.generateId();

        List<OrderDetail> details = command.getDetails().stream()
                .map(it -> OrderDetail.create(order.getId(), it))
                .collect(Collectors.toList());
        BigDecimal totalPrice = details.stream()
                .map(it -> it.getPrice().multiply(BigDecimal.valueOf(it.getCount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        order.setDetails(details);
        order.setTotalPrice(totalPrice);
        return order;
    }
}
