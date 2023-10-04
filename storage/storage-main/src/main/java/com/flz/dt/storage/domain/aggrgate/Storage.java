package com.flz.dt.storage.domain.aggrgate;

import com.flz.dt.common.domain.DomainAggregateRoot;
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
public class Storage extends DomainAggregateRoot {
    private String skuId;
    private String skuName;
    private Long count;

    public void change(Long changeCount) {
        count = count + changeCount;
    }
}
