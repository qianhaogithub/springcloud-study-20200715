package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * @author qianhao
 * @create 2020/7/28-23:37
 */
@SpringBootApplication
@EnableHystrixDashboard
public class HystrixDashbord9001 {

    public static void main(String[] args) {
        SpringApplication.run(HystrixDashbord9001.class,args);
    }
}
