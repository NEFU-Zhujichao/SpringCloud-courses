package com.example.springcloudapi.service;

import com.example.springcloudapi.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class FeignDeptServiceFallbackFactory implements FallbackFactory {
    @Override
    public FeignDeptService create(Throwable throwable) {
        return new FeignDeptService() {
            @Override
            public boolean addDept(Dept dept) {
                return false;
            }

            @Override
            public Dept queryDeptById(Long id) {
                return new Dept()
                        .setDeptno(id)
                        .setDname("由于服务器压力过大，现将此服务暂停一段时间(比如：游戏暂停维护弹出的公告)")
                        .setDbSource("no this user in datasource");
            }

            @Override
            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
