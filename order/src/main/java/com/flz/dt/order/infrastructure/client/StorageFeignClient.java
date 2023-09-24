package com.flz.dt.order.infrastructure.client;

import com.flz.storage.api.StorageApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("storage")
public interface StorageFeignClient extends StorageApi {
}
