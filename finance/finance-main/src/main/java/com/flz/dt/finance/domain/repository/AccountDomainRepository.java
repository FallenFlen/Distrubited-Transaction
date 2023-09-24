package com.flz.dt.finance.domain.repository;

import com.flz.dt.common.exception.BusinessException;
import com.flz.dt.finance.domain.aggrgate.Account;
import com.flz.dt.finance.infrastructure.converter.AccountDOConverter;
import com.flz.dt.finance.infrastructure.repository.AccountJDBCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class AccountDomainRepository {
    private final AccountJDBCRepository accountJDBCRepository;
    private final AccountDOConverter accountDOConverter = AccountDOConverter.INSTANCE;

    public Account findByUserId(String userId) {
        return accountJDBCRepository.findByUserId(userId)
                .map(accountDOConverter::toDomain)
                .orElseThrow(() -> new BusinessException("account not found with user id:" + userId));
    }

    public void save(Account account) {
        accountJDBCRepository.save(accountDOConverter.toEntity(account));
    }
}
