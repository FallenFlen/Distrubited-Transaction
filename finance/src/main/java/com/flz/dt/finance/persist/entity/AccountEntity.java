package com.flz.dt.finance.persist.entity;

import com.flz.dt.common.persist.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

import java.math.BigDecimal;

@Table("account")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountEntity extends BaseEntity {
    private String userId;
    private BigDecimal credit;
}
