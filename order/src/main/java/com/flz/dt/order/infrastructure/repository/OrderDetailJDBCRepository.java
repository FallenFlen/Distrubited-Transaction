package com.flz.dt.order.infrastructure.repository;

import com.flz.dt.order.infrastructure.entity.OrderDetailEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailJDBCRepository extends CrudRepository<OrderDetailEntity, Long> {
}
