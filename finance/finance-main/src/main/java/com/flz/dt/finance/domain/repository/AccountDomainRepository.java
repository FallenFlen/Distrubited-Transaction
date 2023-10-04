package com.flz.dt.finance.domain.repository;

import com.flz.dt.common.exception.BusinessException;
import com.flz.dt.finance.domain.aggrgate.Account;
import com.flz.dt.finance.domain.aggrgate.AccountStatement;
import com.flz.dt.finance.infrastructure.converter.AccountDOConverter;
import com.flz.dt.finance.infrastructure.converter.AccountStatementDOConverter;
import com.flz.dt.finance.infrastructure.entity.AccountStatementEntity;
import com.flz.dt.finance.infrastructure.repository.AccountJDBCRepository;
import com.flz.dt.finance.infrastructure.repository.AccountStatementJDBCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class AccountDomainRepository {
    private final AccountJDBCRepository accountJDBCRepository;
    private final AccountStatementJDBCRepository accountStatementJDBCRepository;
    private final AccountDOConverter accountDOConverter = AccountDOConverter.INSTANCE;
    private final AccountStatementDOConverter accountStatementDOConverter = AccountStatementDOConverter.INSTANCE;

    public Account findByUserId(String userId) {
        Account account = accountJDBCRepository.findByUserId(userId)
                .map(accountDOConverter::toDomain)
                .orElseThrow(() -> new BusinessException("account not found with user id:" + userId));
        List<AccountStatement> statements = accountStatementJDBCRepository.findAllByAccountId(account.getId()).stream()
                .map(accountStatementDOConverter::toDomain)
                .collect(Collectors.toList());
        account.assembleStatements(statements);
        return account;
    }

    public void save(Account account) {
        accountJDBCRepository.save(accountDOConverter.toEntity(account));
        List<AccountStatementEntity> changedStatements = Optional.ofNullable(account.getChangedStatements())
                .orElse(Collections.emptyList())
                .stream()
                .map(accountStatementDOConverter::toDO)
                .collect(Collectors.toList());
        if (!changedStatements.isEmpty()) {
            accountStatementJDBCRepository.saveAll(changedStatements);
        }
    }
}
