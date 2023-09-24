package com.flz.finance.api;

import com.flz.finance.dto.request.UserCreditChangeRequestDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface AccountApi {
    @PutMapping("/account/credit")
    void changeUserCredit(@RequestBody @Valid UserCreditChangeRequestDTO requestDTO);
}
