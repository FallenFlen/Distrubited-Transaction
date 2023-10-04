CREATE TABLE storage
(
    id          varchar(32) primary key,
    sku_id      varchar(32) not null,
    `count`       bigint default 0,
    create_time datetime(3) default CURRENT_TIMESTAMP (3),
    create_by   varchar(50) not null,
    update_time datetime(3) default CURRENT_TIMESTAMP (3),
    update_by   varchar(50) not null,
    version     int(11),
    unique index uq_sku_id(sku_id)
)