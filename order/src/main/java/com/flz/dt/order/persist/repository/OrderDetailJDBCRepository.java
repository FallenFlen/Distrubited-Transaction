package com.flz.dt.order.persist.repository;

import com.flz.dt.order.persist.entity.OrderDetailEntity;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailJDBCRepository extends CrudRepository<OrderDetailEntity, Long> {
}
