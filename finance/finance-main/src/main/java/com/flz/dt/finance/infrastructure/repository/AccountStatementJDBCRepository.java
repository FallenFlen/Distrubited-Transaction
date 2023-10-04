package com.flz.dt.finance.infrastructure.repository;

import com.flz.dt.finance.infrastructure.entity.AccountStatementEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountStatementJDBCRepository extends CrudRepository<AccountStatementEntity, String> {
    List<AccountStatementEntity> findAllByAccountId(String accountId);
}
