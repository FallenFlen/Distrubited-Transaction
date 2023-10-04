CREATE TABLE `account_statement`
(
    id             varchar(32) primary key,
    action         varchar(100)   not null comment '操作类型',
    account_id     varchar(32)    not null COMMENT '账户id',
    changed_amount decimal(24, 2) not null comment '改变的金额',
    balance decimal(24, 2) not null comment '改变金额后的当前余额',
    transaction_id varchar(32)    not null comment '事务id',
    create_time    datetime(3) default CURRENT_TIMESTAMP (3),
    create_by      varchar(50)    not null,
    update_time    datetime(3) default CURRENT_TIMESTAMP (3),
    update_by      varchar(50)    not null,
    version        int(11),
    UNIQUE INDEX uq_idx_transaction_id(`transaction_id`)
);