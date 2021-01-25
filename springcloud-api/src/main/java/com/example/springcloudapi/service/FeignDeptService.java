package com.example.springcloudapi.service;

import com.example.springcloudapi.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "SPRINGCLOUD-PROVIDER-DEPT",
        fallbackFactory = FeignDeptServiceFallbackFactory.class)
@Component
public interface FeignDeptService {
    @PostMapping("/api/add")
    boolean addDept(@RequestBody Dept dept);

    @GetMapping("/api/get/{id}")
    Dept queryDeptById(@PathVariable("id") Long id);

    @GetMapping("/api/list")
    List<Dept> queryAll();
}
