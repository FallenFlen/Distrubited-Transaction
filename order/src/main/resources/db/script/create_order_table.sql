create table `order`
(
    id          varchar(32) primary key,
    user_id     varchar(32)    not null,
    description varchar(1024)  not null,
    total_price decimal(24, 2) not null,
    create_time datetime(3) default CURRENT_TIMESTAMP (3),
    create_by   varchar(50)    not null,
    update_time datetime(3) default CURRENT_TIMESTAMP (3),
    update_by   varchar(50)    not null
);

create table order_detail
(
    id          varchar(32) primary key,
    order_id    varchar(32)    not null,
    sku_id      varchar(32)    not null,
    sku_name    varchar(1024)  not null,
    `count`     bigint         not null,
    price       decimal(24, 2) not null,
    create_time datetime(3) default CURRENT_TIMESTAMP (3),
    create_by   varchar(50)    not null,
    update_time datetime(3) default CURRENT_TIMESTAMP (3),
    update_by   varchar(50)    not null
);