package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qianhao
 * @create 2020/7/19-13:55
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulService8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulService8006.class,args);
    }
}
