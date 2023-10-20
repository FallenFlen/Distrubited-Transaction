package com.flz.dt.order.domain.repository;

import com.flz.dt.order.domain.aggregate.LocalEvent;
import com.flz.dt.order.domain.enums.LocalEventStatus;
import com.flz.dt.order.infrastructure.converter.LocalEventEntityConverter;
import com.flz.dt.order.infrastructure.dataobject.LocalEventDO;
import com.flz.dt.order.infrastructure.repository.LocalEventJDBCRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class LocalEventDomainRepository {
    private final LocalEventJDBCRepository localEventJDBCRepository;
    private final LocalEventEntityConverter converter = LocalEventEntityConverter.INSTANCE;

    public List<LocalEvent> findAllByStatusIn(List<LocalEventStatus> statuses) {
        return localEventJDBCRepository.findAllByStatusIn(statuses).stream()
                .map(converter::toDomain)
                .collect(Collectors.toList());
    }

    public void saveAll(List<LocalEvent> localEvents) {
        List<LocalEventDO> localEventEntities = localEvents.stream()
                .map(converter::toEntity)
                .collect(Collectors.toList());
        localEventJDBCRepository.saveAll(localEventEntities);
    }
}
