create table `account`(
    id varchar(32) primary key ,
    user_id varchar(32) not null ,
    credit decimal(24,2) not null,
    create_time datetime(3) default CURRENT_TIMESTAMP (3),
    create_by   varchar(50)    not null,
    update_time datetime(3) default CURRENT_TIMESTAMP (3),
    update_by   varchar(50)    not null
);