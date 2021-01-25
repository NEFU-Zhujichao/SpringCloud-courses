package com.example.springcloudproviderdepthystrix8001.controller;

import com.example.springcloudapi.pojo.Dept;
import com.example.springcloudproviderdepthystrix8001.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class DeptController {

    @Autowired
    private DeptService deptService;
    @GetMapping("get/{id}")
    @HystrixCommand(fallbackMethod = "hystrixGetDept")
    public Dept getDept(@PathVariable("id") Long id){
        Dept dept = deptService.queryById(id);
        if (dept == null){
            throw new RuntimeException("不存在id为" + id + "的用户");
        }
        return dept;
    }

    public Dept hystrixGetDept(@PathVariable("id") Long id){
        return new Dept()
                .setDeptno(id)
                .setDname("不存在id为" + id + "的用户")
                .setDbSource("no this user in datasource");
    }

}
