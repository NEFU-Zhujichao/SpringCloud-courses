package com.example.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RuleConfig {

    //负载均衡的策略
    @Bean
    public IRule customRule(){
        return new CustomRule(); //默认是轮询，现在是自定义的算法。
    }
}
