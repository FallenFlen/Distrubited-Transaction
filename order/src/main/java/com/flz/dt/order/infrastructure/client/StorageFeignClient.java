package com.flz.dt.order.infrastructure.client;

import com.flz.dt.order.infrastructure.client.interceptor.TokenFeignInterceptor;
import com.flz.storage.api.StorageApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(value = "storage", configuration = TokenFeignInterceptor.class)
public interface StorageFeignClient extends StorageApi {
}
