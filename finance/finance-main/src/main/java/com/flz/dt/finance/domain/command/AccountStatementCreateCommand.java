package com.flz.dt.finance.domain.command;

import com.flz.finance.dto.enums.UserCreditChangeAction;
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
public class AccountStatementCreateCommand {
    private UserCreditChangeAction action;
    private String accountId;
    private BigDecimal changedAmount;
    private BigDecimal balance;
    private String transactionId;
}
