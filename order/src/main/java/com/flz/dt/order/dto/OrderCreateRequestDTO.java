package com.flz.dt.order.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
public class OrderCreateRequestDTO {
    @NotBlank
    private String description;
    @NotNull
    @NotEmpty
    @Valid
    private List<OrderDetailCreateRequestDTO> details;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class OrderDetailCreateRequestDTO {
        @NotNull
        private Long skuId;
        @NotBlank
        private String skuName;
        @NotNull
        private Long count;
        @NotNull
        @Positive
        private BigDecimal price;
    }
}
