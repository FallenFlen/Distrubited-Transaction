package com.flz.dt.finance.infrastructure.repository;

import com.flz.dt.finance.infrastructure.dataobject.AccountStatementDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AccountStatementJDBCRepository extends CrudRepository<AccountStatementDO, String> {
    List<AccountStatementDO> findAllByAccountId(String accountId);
}
