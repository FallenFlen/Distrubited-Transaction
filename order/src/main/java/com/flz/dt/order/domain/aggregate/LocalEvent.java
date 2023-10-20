package com.flz.dt.order.domain.aggregate;

import com.flz.dt.common.domain.DomainAggregateRoot;
import com.flz.dt.order.domain.command.LocalEventCreateCommand;
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
    private String body;
    private Integer retryCount;
    private String failReason;

    public void fail(int maxRetryTime, String failReason) {
        this.status = LocalEventStatus.FAILED;
        this.retryCount++;
        this.failReason = failReason;
        if (this.retryCount > maxRetryTime) {
            this.status = LocalEventStatus.DEATH;
        }
    }

    public void success() {
        this.status = LocalEventStatus.SUCCESS;
    }

    public static LocalEvent create(LocalEventCreateCommand command) {
        LocalEvent localEvent = LocalEvent.builder()
                .type(command.getType())
                .status(LocalEventStatus.PENDING)
                .businessId(command.getBusinessId())
                .body(command.getBody())
                .retryCount(0)
                .build();
        localEvent.generateId();
        localEvent.createBy("System");
        return localEvent;
    }
}
