package com.flz.dt.common.persist.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BaseEntity {
    @Id
    private String id;
    private String createBy;
    @CreatedDate
    private LocalDateTime createTime;
    private String updateBy;
    @LastModifiedDate
    private LocalDateTime updateTime;
    @Version
    private Integer version;
}
