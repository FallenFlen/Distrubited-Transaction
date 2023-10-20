package com.flz.dt.order.infrastructure.dataobject;

import com.flz.dt.common.persist.entity.BaseDO;
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
@Table("order")
public class OrderDO extends BaseDO {
    private String userId;
    private String description;
    private BigDecimal totalPrice;
}
