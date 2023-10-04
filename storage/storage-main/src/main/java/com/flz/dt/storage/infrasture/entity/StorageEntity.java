package com.flz.dt.storage.infrasture.entity;

import com.flz.dt.common.persist.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.relational.core.mapping.Table;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("storage")
public class StorageEntity extends BaseEntity {
    private String skuId;
    private String skuName;
    private Long count;
}
