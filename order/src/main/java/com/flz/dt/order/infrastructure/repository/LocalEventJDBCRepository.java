package com.flz.dt.order.infrastructure.repository;

import com.flz.dt.order.infrastructure.entity.LocalEventEntity;
import org.springframework.data.repository.CrudRepository;

public interface LocalEventJDBCRepository extends CrudRepository<LocalEventEntity, String> {

}
