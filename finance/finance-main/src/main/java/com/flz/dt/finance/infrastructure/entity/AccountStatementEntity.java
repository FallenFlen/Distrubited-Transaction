package com.flz.dt.finance.infrastructure.entity;

import com.flz.dt.common.persist.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("account_statement")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountStatementEntity extends BaseEntity {
    private String action;
    private String accountId;
    private BigDecimal changedAmount;
    private BigDecimal balance;
    private String transactionId;
}
