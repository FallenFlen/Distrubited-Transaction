package com.flz.dt.order.infrastructure.repository;

import com.flz.dt.order.infrastructure.dataobject.OrderDO;
import org.springframework.data.repository.CrudRepository;

public interface OrderJDBCRepository extends CrudRepository<OrderDO, Long> {
}
