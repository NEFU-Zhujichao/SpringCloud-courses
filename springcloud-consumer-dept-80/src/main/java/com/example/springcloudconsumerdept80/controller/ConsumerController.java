package com.example.springcloudconsumerdept80.controller;

import com.example.springcloudapi.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/")
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;
    @Value("${consumerUrl}")
    private String consumerUrl;

    @PostMapping("add")
    public boolean addDept(@RequestBody Dept dept){
        System.out.println(consumerUrl);
        return restTemplate.postForObject(consumerUrl + "add",dept,boolean.class);
    }

    @GetMapping("get/{id}")
    public Dept getDept(@PathVariable("id") long id){
        String x = consumerUrl + "get/" + id;
        System.out.println(x);
        return restTemplate.getForObject(consumerUrl + "get/" + id, Dept.class);
    }

    @GetMapping("list")
    public List<Dept> getAll(){
        return restTemplate.getForObject(consumerUrl + "list", List.class);
    }

}
