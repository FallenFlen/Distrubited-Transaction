package com.flz.dt.storage.domain.aggrgate;

import com.flz.dt.common.domain.DomainAggregateRoot;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter(value = AccessLevel.PROTECTED)
@Builder
public class Storage extends DomainAggregateRoot {
    private String skuId;
    private Long count;

    public void change(Long changeCount) {
        count = count + changeCount;
    }
}
