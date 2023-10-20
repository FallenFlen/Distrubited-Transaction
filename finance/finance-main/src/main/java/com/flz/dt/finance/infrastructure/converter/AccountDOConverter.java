package com.flz.dt.finance.infrastructure.converter;

import com.flz.dt.finance.domain.aggrgate.Account;
import com.flz.dt.finance.infrastructure.dataobject.AccountDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountDOConverter {
    AccountDOConverter INSTANCE = Mappers.getMapper(AccountDOConverter.class);

    Account toDomain(AccountDO accountDO);

    AccountDO toEntity(Account account);
}
