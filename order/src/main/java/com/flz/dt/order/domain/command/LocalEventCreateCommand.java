package com.flz.dt.order.domain.command;

import com.flz.dt.order.domain.enums.LocalEventType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class LocalEventCreateCommand {
    private LocalEventType type;
    private String businessId;
    private String body;
}
