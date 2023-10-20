package com.flz.dt.finance.infrastructure.converter;

import com.flz.dt.finance.domain.aggrgate.AccountStatement;
import com.flz.dt.finance.infrastructure.dataobject.AccountStatementDO;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AccountStatementDOConverter {
    AccountStatementDOConverter INSTANCE = Mappers.getMapper(AccountStatementDOConverter.class);

    AccountStatement toDomain(AccountStatementDO accountStatementEntity);

    AccountStatementDO toDO(AccountStatement accountStatement);
}
