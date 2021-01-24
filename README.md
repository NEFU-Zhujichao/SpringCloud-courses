```text
2021/1/24
Feign: 使用接口方式调用微服务
Hystrix: 服务熔断，假设有一个服务崩了，我们会弹出一个提示信息。
        @HystrixCommand(可以绑定方法) 在服务崩了的情况将会调用绑定的方法。
         服务降级，假设有一个服务不怎么用，我们可以手动将服务关掉，然后返回指定的信息，
         将资源释放掉，给其他微服务使用。
         Dashboard 流量监控，监控我们的微服务的请求数量，出错的请求比率等等。
zuul(Gateway) 路由网关 
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
负载均衡(Ribbon)：spring-cloud-starter-netflix-ribbon
面向接口调用微服务(Feign)：spring-cloud-starter-openfeign
服务熔断,服务降级(Hystrix) ：spring-cloud-starter-netflix-hystrix
服务监控：spring-cloud-starter-netflix-hystrix-dashboard
网关(zuul)：spring-cloud-starter-netflix-zuul
```
