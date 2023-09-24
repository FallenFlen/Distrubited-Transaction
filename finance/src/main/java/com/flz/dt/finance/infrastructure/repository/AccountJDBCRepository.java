package com.flz.dt.finance.infrastructure.repository;

import com.flz.dt.finance.infrastructure.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountJDBCRepository extends CrudRepository<AccountEntity, String> {
    Optional<AccountEntity> findByUserId(String userId);
}
