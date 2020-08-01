package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qianhao
 * @create 2020/7/19-12:18
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZKService6002 {

    public static void main(String[] args) {
        SpringApplication.run(OrderZKService6002.class);
    }
}
