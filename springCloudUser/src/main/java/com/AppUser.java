package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

/**
 * User启动类
 */
@SpringBootApplication
@EnableEurekaClient
@EnableHystrix
public class AppUser {
    public static void main(String[] args) {
        SpringApplication.run(AppUser.class);
    }
}
