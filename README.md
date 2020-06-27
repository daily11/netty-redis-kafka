启动流程
1 NettyServer
2 NettyClient
3 NettyRedisKafkaApplication

程序运行流程
1 NettyClient向NettyServer轮询发送点位信息
2 NettyServer接收点位信息，并将点位信息发送给redis缓存
3 网页请求"localhost:8080/get/position"，执行流程：
    3.1 获取redis中保存的点位信息
    3.2 将获取到的点位信息发送给kafka，并消费
    3.3 返回点位信息给客户端
    
kafka启动指令：
1 bin\windows\zookeeper-server-start.bat config\zookeeper.properties
2  bin\windows\kafka-server-start.bat config\server.properties

redis启动指令
redis-server.exe redis.windows.conf