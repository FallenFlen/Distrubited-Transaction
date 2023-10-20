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
@Table("order_detail")
public class OrderDetailDO extends BaseDO {
    private String orderId;
    private String skuId;
    private String skuName;
    private Long count;
    private BigDecimal price;
}
