package com.example.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author qianhao
 * @create 2020/7/18-11:35
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7001StartMain {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001StartMain.class,args);
    }
}

