package com.flz.dt.finance.presentation.controller;

import com.flz.dt.finance.application.service.AccountService;
import com.flz.finance.api.AccountApi;
import com.flz.finance.dto.request.UserCreditChangeRequestDTO;
import com.flz.finance.dto.response.FinanceInfoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/account/credit")
public class AccountController implements AccountApi {
    private final AccountService accountService;

    @PutMapping
    @Override
    public void changeUserCredit(@RequestBody @Valid UserCreditChangeRequestDTO requestDTO) {
        accountService.changeUserCredit(requestDTO);
    }

    @GetMapping("/{userId}")
    @Override
    public FinanceInfoResponseDTO fetchFinanceInfo(@PathVariable String userId) {
        return accountService.fetchFinanceInfo(userId);
    }
}
