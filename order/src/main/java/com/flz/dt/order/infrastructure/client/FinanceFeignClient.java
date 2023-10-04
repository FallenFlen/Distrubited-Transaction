package com.flz.dt.order.infrastructure.client;

import com.flz.dt.order.infrastructure.client.interceptor.TokenFeignInterceptor;
import com.flz.finance.api.AccountApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "finance", configuration = TokenFeignInterceptor.class)
public interface FinanceFeignClient extends AccountApi {

}
