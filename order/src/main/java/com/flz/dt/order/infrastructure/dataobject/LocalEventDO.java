package com.flz.dt.order.infrastructure.dataobject;

import com.flz.dt.common.persist.entity.BaseDO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("local_event")
public class LocalEventDO extends BaseDO {
    private String type;
    private String status;
    private String businessId;
    private String body;
    private Integer retryCount;
    private String failReason;
}
