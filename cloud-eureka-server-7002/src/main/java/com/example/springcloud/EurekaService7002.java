package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author qianhao
 * @create 2020/7/18-15:37
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaService7002 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaService7002.class);
    }
}
