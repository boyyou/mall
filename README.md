# 写在最前
如果想快速部署黄金海滩商城系统，请先参考本篇文档。 

# 特别说明
确保你的IDE或STS 已经安装lombok
建议使用 IDEA 2018+ 启动效果会更好
内存较小开发机 每个微服务建议设置 -Xms128m -Xmx256m

# 环境说明
jdk 1.8
mysql 5.7
redis 3.2+
node 8.0+
npm 6.0+

# 一、配置数据库
参数说明
版本： mysql5.7+
默认字符集: utf8mb4
默认排序规则: utf8mb4_general_ci

要求设置数据库大小写不敏感
lower_case_table_names = 1  
脚本说明 
1scheme.sql    建库语句
2gds_base.sql     核心数据库
3gds_job.sql  定时任务相关数据库
4gds_mp.sql   微信公众号相关数据库
5gds_config.sql  配置中心
6其他模块数据库   未完待续

# 二、配置本地hosts 建议使用 switchhost）
修改本地hosts文件中存在以下片段 ,以及后续添加的业务模块
127.0.0.1 gds-register
127.0.0.1 gds-auth
127.0.0.1 gds-gateway
127.0.0.1 gds-upms
127.0.0.1 gds-redis
127.0.0.1 gds-mysql
启动 GdsNacosApplication
浏览器访问 http://127.0.0.1:8848/nacos

# 三、数据库配置修改
可进入nacos配置列表中修改数据库配置

# 四、启动顺序（基础模块）
1. GdsNacosApplication   
2. GdsGatewayApplication  
3. GdsAuthApplication 
4. GdsAdminApplication 
5. 其他业务模块

## 后端模块说明
mall
├── gds-ui -- 前端工程[8080]
├── gds-auth -- Oauth2.0认证授权中心[3000]
├── gds-common -- 系统公共模块 
├    ├── gds-common-bom -- 公共依赖版本
├    ├── gds-common-core -- 公共工具类核心包
├    ├── gds-common-data -- 数据相关
├    ├── gds-common-gateway -- 动态路由定义
├    ├── gds-common-log -- 日志服务
├    ├── gds-common-minio -- minio分布式对象存储服务（文件系统）
├    └── gds-common-security -- 安全工具类
├    └── gds-common-swagger -- Swagger Api文档生成
├    └── gds-common-transaction -- 分布式事务工具包
├── gds-register -- 注册中心、配置中心[8848]
├── gds-gateway -- Spring Cloud Gateway网关[9999]
├── gds-upms -- 通用用户权限管理模块
├    └── gds-upms-api -- 通用用户权限管理系统公共api模块
├    └── gds-upms-biz -- 通用用户权限管理系统业务处理模块[4000]
└── gds-visual  -- 图形化模块 
├    ├── gds-monitor -- springBootAdmin服务安全监控 [5001]
├    ├── gds-daemon-quartz -- quartz后台定时任务[quartz]
├    └── gds-sso-client-demo -- 单点登录接入示例
├    └── gds-mp-manager -- 微信管理模块
└──  └── gds-tx-manager -- gds分布式事务管理[5004]