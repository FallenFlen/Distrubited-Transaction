分布式事务解决方案
master分支->

业务流程
订单模块下单：扣减财务模块额度->扣减库存模块商品库存->订单模块本地创建订单

AC
使用分布式事务保证订单模块下单流程的数据一致性