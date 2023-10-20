CREATE TABLE `local_event`
(
    id          varchar(32) primary key,
    type        varchar(100) not null comment '事件类型',
    status      varchar(100) not null comment '事件状态',
    business_id varchar(32) null comment '业务id',
    body        text null comment '请求体',
    retry_count int(11) null default 0 comment '重试次数',
    fail_reason text null comment '失败原因',
    create_time datetime(3) default CURRENT_TIMESTAMP (3),
    create_by   varchar(50)  not null,
    update_time datetime(3) default CURRENT_TIMESTAMP (3),
    update_by   varchar(50)  not null,
    version     int(11)
)