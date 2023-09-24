package com.flz.dt.order.infrastructure.client;

import com.flz.finance.api.AccountApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("finance")
public interface FinanceFeignClient extends AccountApi {

}
