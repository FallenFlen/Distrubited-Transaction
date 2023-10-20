package com.flz.dt.finance.infrastructure.repository;

import com.flz.dt.finance.infrastructure.dataobject.AccountDO;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountJDBCRepository extends CrudRepository<AccountDO, String> {
    Optional<AccountDO> findByUserId(String userId);
}
