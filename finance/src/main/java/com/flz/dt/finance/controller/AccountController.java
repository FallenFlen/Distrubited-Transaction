package com.flz.dt.finance.controller;

import com.flz.finance.api.AccountApi;
import com.flz.finance.dto.request.UserCreditChangeRequestDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account/credit")
public class AccountController implements AccountApi {

    @PutMapping
    @Override
    public void changeUserCredit(@RequestBody @Valid UserCreditChangeRequestDTO requestDTO) {

    }
}
