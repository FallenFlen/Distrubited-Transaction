package com.flz.dt.order.infrastructure.repository;

import com.flz.dt.order.domain.enums.LocalEventStatus;
import com.flz.dt.order.infrastructure.dataobject.LocalEventDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface LocalEventJDBCRepository extends CrudRepository<LocalEventDO, String> {
    List<LocalEventDO> findAllByStatusIn(List<LocalEventStatus> statuses);
}
