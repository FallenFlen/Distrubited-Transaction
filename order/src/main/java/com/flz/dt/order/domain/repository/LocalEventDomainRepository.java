package com.flz.dt.order.domain.repository;

import com.flz.dt.order.domain.aggregate.LocalEvent;
import com.flz.dt.order.infrastructure.converter.LocalEventEntityConverter;
import com.flz.dt.order.infrastructure.entity.LocalEventEntity;
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

    public void saveAll(List<LocalEvent> localEvents) {
        List<LocalEventEntity> localEventEntities = localEvents.stream()
                .map(converter::toEntity)
                .collect(Collectors.toList());
        localEventJDBCRepository.saveAll(localEventEntities);
    }
}
