package com.flz.dt.order.infrastructure.entity;

import com.flz.dt.common.persist.entity.BaseEntity;
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
public class LocalEventEntity extends BaseEntity {
    private String type;
    private String status;
    private String businessId;
    private String body;
    private Integer retryCount;
}