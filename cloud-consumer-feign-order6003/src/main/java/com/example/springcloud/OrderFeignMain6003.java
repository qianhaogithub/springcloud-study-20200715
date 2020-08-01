package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author qianhao
 * @create 2020/7/19-22:55
 */
@SpringBootApplication
@EnableFeignClients
public class OrderFeignMain6003 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeignMain6003.class,args);
    }
}
