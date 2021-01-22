package com.example.springcloudproviderdept8001.controller;

import com.example.springcloudapi.pojo.Dept;
import com.example.springcloudproviderdept8001.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/")
public class DeptController {

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

}
