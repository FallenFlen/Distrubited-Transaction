package com.flz.dt.order.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrderCreateCommand {
    private String description;
    private List<OrderDetailCreateCommand> details;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class OrderDetailCreateCommand {
        private String skuId;
        private String skuName;
        private Long count;
        private BigDecimal price;
    }
}
