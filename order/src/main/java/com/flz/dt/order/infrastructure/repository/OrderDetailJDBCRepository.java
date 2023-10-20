package com.flz.dt.order.infrastructure.repository;

import com.flz.dt.order.infrastructure.dataobject.OrderDetailDO;
import org.springframework.data.repository.CrudRepository;

public interface OrderDetailJDBCRepository extends CrudRepository<OrderDetailDO, Long> {
}
