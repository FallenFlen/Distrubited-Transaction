分布式事务解决方案  
master分支-> 基本业务逻辑的实现，无任何分布式事务的实现
01_local_event_without_mq：使用本地事件表+http请求实现
02_local_event_with_rocket_mq：使用本地事件表+rocketmq实现

业务流程  
订单模块下单：扣减财务模块额度->扣减库存模块商品库存->订单模块本地创建订单  

AC  
使用分布式事务保证订单模块下单流程的数据一致性  