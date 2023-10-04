package com.flz.finance.dto.request;

import com.flz.finance.dto.enums.UserCreditChangeAction;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UserCreditChangeRequestDTO {
    @NotBlank
    private String userId;
    @NotNull
    private UserCreditChangeAction action;
    @NotNull
    private BigDecimal amount;
}
