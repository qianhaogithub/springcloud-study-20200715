package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qianhao
 * @create 2020/7/19-9:56
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentProvider8004 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentProvider8004.class);
    }
}
