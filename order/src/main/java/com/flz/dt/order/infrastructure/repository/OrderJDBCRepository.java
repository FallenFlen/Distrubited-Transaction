package com.flz.dt.order.infrastructure.repository;

import com.flz.dt.order.infrastructure.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderJDBCRepository extends CrudRepository<OrderEntity, Long> {
}
