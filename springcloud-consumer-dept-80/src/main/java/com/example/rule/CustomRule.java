package com.example.rule;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.AbstractLoadBalancerRule;
import com.netflix.loadbalancer.ILoadBalancer;
import com.netflix.loadbalancer.Server;

import java.util.List;

public class CustomRule extends AbstractLoadBalancerRule {

    private int total = 0;  //微服务被调用的次数
    private int currentIndex = 0;  //当前是谁在提供服务

    @SuppressWarnings({"RCN_REDUNDANT_NULLCHECK_OF_NULL_VALUE"})
    public Server choose(ILoadBalancer lb, Object key) {
        if (lb == null) {
            return null;
        } else {
            Server server = null;

            while(server == null) {
                if (Thread.interrupted()) {
                    return null;
                }

                List<Server> upList = lb.getReachableServers(); //获取活着的服务
                List<Server> allList = lb.getAllServers();      //获取全部服务
                int serverCount = allList.size();
                if (serverCount == 0) {
                    return null;
                }

//                int index = this.chooseRandomInt(serverCount);
//                server = (Server)upList.get(index);
               //-------------------------------------//
                    if (total < 3){
                        server = (Server)upList.get(currentIndex);
                        total++;
                    } else {
                        total = 1;
                        currentIndex++;
                        if (currentIndex > upList.size()){
                            currentIndex = 0;
                        }
                        server = (Server)upList.get(currentIndex);
                    }
                // -------------------------------------//
                if (server == null) {
                    Thread.yield();
                } else {
                    if (server.isAlive()) {
                        return server;
                    }

                    server = null;
                    Thread.yield();
                }
            }

            return server;
        }
    }

    public Server choose(Object key) {
        return this.choose(this.getLoadBalancer(), key);
    }

    public void initWithNiwsConfig(IClientConfig clientConfig) {
    }
}
