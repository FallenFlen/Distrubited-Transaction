package com.flz.dt.order.presentation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PurchaseSummaryResponseDTO {
    private FinanceInfo financeInfo;
    private List<StorageInfo> storageInfos;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class FinanceInfo {
        private String userId;
        private BigDecimal credit;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class StorageInfo {
        private String skuId;
        private String skuName;
        private Long storage;
    }
}
