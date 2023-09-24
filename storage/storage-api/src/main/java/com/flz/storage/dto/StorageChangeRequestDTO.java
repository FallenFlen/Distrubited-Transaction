package com.flz.storage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StorageChangeRequestDTO {
    private List<SkuStorage> skuStorages;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class SkuStorage {
        private String skuId;
        private Long count;
    }
}
