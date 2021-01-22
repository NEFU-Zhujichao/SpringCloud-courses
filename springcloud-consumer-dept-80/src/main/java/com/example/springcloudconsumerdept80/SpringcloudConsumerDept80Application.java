package com.example.springcloudconsumerdept80;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SpringcloudConsumerDept80Application {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudConsumerDept80Application.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
