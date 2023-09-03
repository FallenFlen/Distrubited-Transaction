package com.flz.dt.finance.persist.domain;

import com.flz.dt.common.domain.DomainAggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Account extends DomainAggregateRoot {
    private String userId;
    private BigDecimal credit;
}
