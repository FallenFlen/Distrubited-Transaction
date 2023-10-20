package com.flz.dt.storage.infrasture.dataobject;

import com.flz.dt.common.persist.entity.BaseDO;
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
public class StorageDO extends BaseDO {
    private String skuId;
    private String skuName;
    private Long count;
}
