```text
2021/1/25
SpringCloud-config(实现配置与代码解耦)
客户端连接服务器端 ServerConfig
服务器端连接远程仓库
bootstrap.yml 系统级别配置 application.yml 应用程序配置
1.导入依赖
2.编写bootstrap.yml 由本地客户端连接服务端 然后服务端去连接github远程仓库
3.服务端主启动类上开启@EnableConfigServer 客户端不用添加注解
```
```yaml
spring:
  cloud:
    config:
      name: config-dept
      lable: master
      profile: dev
      uri: http://localhost:3344
```
```text
2021/1/24
Feign: 使用接口方式调用微服务
Hystrix: 服务熔断(与服务端有关)，某个服务超时或者异常，我们会弹出一个提示信息。
         @HystrixCommand(可以绑定方法) 在服务崩了的情况将会调用绑定的方法。
         服务降级(与客户端有关)，从网站整体请求负载考虑，假设有一个服务不怎么用，
         我们可以手动将服务关掉，将资源释放掉，给其他微服务使用。此时在客户端，
         我们可以准备一个FallbackFactory，返回一个缺省值。当度过高并发时再将此服务开启。
         流量监控(Dashboard)，监控我们的微服务的请求数量，出错的请求比率等等。
zuul(Gateway) 路由网关 zuul需要注册到Eureka中。(外部访问微服务的统一入口)
路由和过滤@EnableZuulProxy

```
```text
SpringCloud课外学习
版本依赖
SpringBoot：2.3.5.RELEASE SpringCloud： Hoxton.SR9
以下版本全为：2.2.6.RELEASE
服务注册与发现(Eureka)：
    客户端：spring-cloud-starter-netflix-eureka-client 
    服务端：spring-cloud-starter-netflix-eureka-server
按微服务名字调用(Ribbon)：spring-cloud-starter-netflix-ribbon
面向接口调用微服务(Feign)：spring-cloud-starter-openfeign
服务熔断,服务降级(Hystrix)：spring-cloud-starter-netflix-hystrix
服务监控：spring-cloud-starter-netflix-hystrix-dashboard
网关(zuul)：spring-cloud-starter-netflix-zuul
```
