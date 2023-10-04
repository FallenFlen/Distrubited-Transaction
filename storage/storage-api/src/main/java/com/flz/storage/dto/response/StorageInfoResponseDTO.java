package com.flz.storage.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class StorageInfoResponseDTO {
    private String skuId;
    private String skuName;
    private Long storage;
}
