package com.flz.dt.finance.application.service;

import com.flz.dt.common.exception.BusinessException;
import com.flz.dt.finance.domain.aggrgate.Account;
import com.flz.dt.finance.domain.repository.AccountDomainRepository;
import com.flz.finance.dto.request.UserCreditChangeRequestDTO;
import com.flz.finance.dto.response.FinanceInfoResponseDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountDomainRepository accountDomainRepository;
    private final RedisTemplate redisTemplate;

    @Transactional
    public void changeUserCredit(UserCreditChangeRequestDTO requestDTO) {
        // 动账需保证幂等
        String redisKey = requestDTO.getAction().name().concat("_").concat(requestDTO.getTransactionId());
        // setnx ttl:1h
        if (!Boolean.TRUE.equals(redisTemplate.opsForValue().setIfAbsent(redisKey, "CREDIT_ROLLBACK", 1, TimeUnit.HOURS))) {
            log.info("avoid duplicate operating account with:{}", redisKey);
            return;
        }

        String userId = requestDTO.getUserId();
        BigDecimal amount = requestDTO.getAmount();

        // 用户账户找不到报错
        Account account = accountDomainRepository.findByUserId(userId);
        // 扣减额度时，不足报错
        if (amount.compareTo(BigDecimal.ZERO) < 0 && account.getCredit().compareTo(amount.abs()) < 0) {
            throw new BusinessException(String.format("user[%s] credit[%s] is not enough for operate amount[%s]",
                    userId, account.getCredit(), amount));
        }
        // 变动金额
        account.change(amount, requestDTO.getAction(), requestDTO.getTransactionId());
        accountDomainRepository.save(account);
    }

    public FinanceInfoResponseDTO fetchFinanceInfo(String userId) {
        Account account = accountDomainRepository.findByUserId(userId);
        return new FinanceInfoResponseDTO(userId, account.getCredit());
    }
}
