package com.flz.dt.order.infrastructure.repository;

import com.flz.dt.order.domain.enums.LocalEventStatus;
import com.flz.dt.order.infrastructure.entity.LocalEventEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocalEventJDBCRepository extends CrudRepository<LocalEventEntity, String> {
    List<LocalEventEntity> findAllByStatusIn(List<LocalEventStatus> statuses);
}
