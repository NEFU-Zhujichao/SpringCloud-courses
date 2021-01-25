package com.example.springcloudconsumerdeptopenfeign.controller;

import com.example.springcloudapi.pojo.Dept;
import com.example.springcloudapi.service.FeignDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class ConsumerController {

    @Qualifier("com.example.springcloudapi.service.FeignDeptService")
    @Autowired
    private FeignDeptService service;

    @PostMapping("add")
    public boolean addDept(@RequestBody Dept dept){
        return service.addDept(dept);
    }

    @GetMapping("get/{id}")
    public Dept getDept(@PathVariable("id") long id){
        return service.queryDeptById(id);
    }

    @GetMapping("list")
    public List<Dept> getAll(){
        return service.queryAll();
    }

}
