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
####SpringCloud学习#####
整理再uber-project中了，不再赘述。
```