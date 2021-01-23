package com.example.springcloudproviderdept8001.controller;

import com.example.springcloudapi.pojo.Dept;
import com.example.springcloudproviderdept8001.service.DeptService;
import com.netflix.appinfo.InstanceInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
@Slf4j
public class DeptController {

    @Autowired
    private DiscoveryClient client;

    @Autowired
    private DeptService deptService;
    @PostMapping("add")
    public Boolean addDept(@RequestBody Dept dept){
        return deptService.addDept(dept);
    }
    @GetMapping("get/{deptno}")
    public Dept getDept(@PathVariable("deptno") Long id){
        return deptService.queryById(id);
    }

    @GetMapping("list")
    public List<Dept> getAll(){
        return deptService.queryAll();
    }
    @GetMapping("discovery")
    public Object discovery(){
        List<String> services = client.getServices();
        log.debug("discovery=>services" + services);
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-PROVIDER-DEPT");
        instances.forEach(x -> {
            log.debug(x.getHost());
            log.debug(x.getInstanceId());
            log.debug(x.getServiceId());
            log.debug("{}",x.getPort());
            log.debug("{}",x.getUri());
        });
        return this.client;
    }

}
