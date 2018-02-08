# jdbc-cruid
简单地封装了jdbc,使用类似于spring-jdbc


### 功能
- 封装了 四个简单的增删改查
- 查找一组(list)
- batch操作

### 特色
- 使用dbcp2连接池,轻量,性能虽不强,但与JDBC天生一对.
- 封装JDBCUtil,简单易用,自动创建连接池,管理连接通过配置文件即可.
- 抽象封装增删改查的方法,使用需继承,良好运用模块化的思维.
### 依赖
commons-dbcp2-2.2.0.jar
commons-dbutils-1.7.jar
commons-logging-1.2.jar
commons-pool2-2.5.0.jar
mysql-connector-java-5.1.45-bin.jar

### 使用方式
- 新建一个XXXDao
- 继承 JdbcRootDao
- 传入方法的参数即可(默认已实现方法).

### 结构
- com.rk
-      |--dao
-         |   |--Interface RootDao
-         |   |--Abstract class JdbcRootDao
-         |
-         |--util
-             |--JDBCUtil
