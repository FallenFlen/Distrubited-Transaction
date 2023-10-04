package com.flz.dt.order.domain.aggregate;

import com.flz.dt.common.domain.DomainAggregateRoot;
import com.flz.dt.order.domain.enums.LocalEventStatus;
import com.flz.dt.order.domain.enums.LocalEventType;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter(value = AccessLevel.PROTECTED)
@SuperBuilder
public class LocalEvent extends DomainAggregateRoot {
    private LocalEventType type;
    private LocalEventStatus status;
    private String businessId;
    private Integer retryCount;
}
