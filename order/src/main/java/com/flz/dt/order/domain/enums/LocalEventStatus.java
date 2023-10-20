package com.flz.dt.order.domain.enums;

import java.util.List;

public enum LocalEventStatus {
    PENDING,
    FAILED,
    SUCCESS,
    DEATH;

    public static List<LocalEventStatus> pendingProcessedStatus() {
        return List.of(PENDING, FAILED);
    }
}
