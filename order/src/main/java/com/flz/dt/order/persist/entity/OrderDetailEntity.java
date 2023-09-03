package com.flz.dt.order.persist.entity;

import com.flz.dt.order.persist.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("order_detail")
public class OrderDetailEntity extends BaseEntity {
    private String orderId;
    private String skuId;
    private String skuName;
    private Long count;
    private BigDecimal price;
}
