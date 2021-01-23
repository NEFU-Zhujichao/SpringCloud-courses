package com.example.springcloudproviderdept8003;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringcloudProviderDept8003Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudProviderDept8003Application.class, args);
    }

}
