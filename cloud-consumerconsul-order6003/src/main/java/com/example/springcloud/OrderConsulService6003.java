package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author qianhao
 * @create 2020/7/19-14:35
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderConsulService6003 {

    public static void main(String[] args) {
        SpringApplication.run(OrderConsulService6003.class,args);
    }
}
