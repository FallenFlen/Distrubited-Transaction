package com.flz.dt.finance.domain.aggrgate;

import com.flz.dt.common.context.UserContext;
import com.flz.dt.common.domain.DomainAggregateRoot;
import com.flz.dt.finance.domain.command.AccountStatementCreateCommand;
import com.flz.finance.dto.enums.UserCreditChangeAction;
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
public class AccountStatement extends DomainAggregateRoot {
    private UserCreditChangeAction action;
    private String accountId;
    private BigDecimal changedAmount;
    private BigDecimal balance;
    private String transactionId;

    public static AccountStatement create(AccountStatementCreateCommand command) {
        AccountStatement accountStatement = AccountStatement.builder()
                .action(command.getAction())
                .accountId(command.getAccountId())
                .changedAmount(command.getChangedAmount())
                .balance(command.getBalance())
                .transactionId(command.getTransactionId())
                .build();
        accountStatement.generateId();
        accountStatement.createBy(UserContext.tryGetUserOrElseSystem().getId());
        return accountStatement;
    }
}
