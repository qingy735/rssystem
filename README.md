# rssystem
### JavaWeb大作业
#### 目录结构
    cn.edu.henu
##### dao
    持久层；负责数据库原子操作，增删改查
##### service
    业务层；对dao层进行再次封装成一个服务
##### controller
    负责请求转发
##### bean
    JavaBean对象
##### intercept
    拦截器
##### util
    工具类
#### 2020-11-25
    1、修改dao层结构  
        a.继承CrudDao
        b.数据库采用Mybatis技术实现
        c.添加log4j日志
    2、修改商家和消费者登录为异步登录