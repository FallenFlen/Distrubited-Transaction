package com.flz.dt.finance.domain.aggrgate;

import com.flz.dt.common.domain.DomainAggregateRoot;
import com.flz.dt.finance.domain.command.AccountStatementCreateCommand;
import com.flz.finance.dto.enums.UserCreditChangeAction;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class Account extends DomainAggregateRoot {
    private String userId;
    private BigDecimal credit;
    private List<AccountStatement> statements;
    private List<AccountStatement> changedStatements;

    public void change(BigDecimal amount, UserCreditChangeAction action, String transactionId) {
        this.credit = this.credit.add(amount);
        if (changedStatements == null) {
            changedStatements = new ArrayList<>();
        }

        AccountStatementCreateCommand accountStatementCreateCommand = AccountStatementCreateCommand.builder()
                .accountId(this.id)
                .changedAmount(amount)
                .balance(this.credit)
                .action(action)
                .transactionId(transactionId)
                .build();
        AccountStatement statement = AccountStatement.create(accountStatementCreateCommand);
        changedStatements.add(statement);
    }

    public void assembleStatements(List<AccountStatement> statements) {
        this.statements = statements;
    }
}
