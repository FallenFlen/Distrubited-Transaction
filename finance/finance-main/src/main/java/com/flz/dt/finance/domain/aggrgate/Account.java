package com.flz.dt.finance.domain.aggrgate;

import com.flz.dt.common.domain.DomainAggregateRoot;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Account extends DomainAggregateRoot {
    private String userId;
    private BigDecimal credit;

    public void change(BigDecimal amount) {
        this.credit = this.credit.add(amount);
    }
}
