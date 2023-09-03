package com.flz.dt.order.persist.repository;

import com.flz.dt.order.persist.entity.OrderEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderJDBCRepository extends CrudRepository<OrderEntity, Long> {
}
