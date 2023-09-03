package com.flz.dt.common.domain;

import com.flz.dt.common.utils.IdGenerator;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter(value = AccessLevel.PROTECTED)
@SuperBuilder
public abstract class DomainAggregateRoot {
    private String id;
    private String createBy;
    private LocalDateTime createTime;
    private String updateBy;
    private LocalDateTime updateTime;

    protected void generateId() {
        this.id = IdGenerator.randomId();
    }

    protected void createBy(String userName) {
        this.createBy = userName;
        this.createTime = LocalDateTime.now();
        updateBy(userName);
    }

    protected void updateBy(String userName) {
        this.updateBy = userName;
        this.updateTime = LocalDateTime.now();
    }
}
