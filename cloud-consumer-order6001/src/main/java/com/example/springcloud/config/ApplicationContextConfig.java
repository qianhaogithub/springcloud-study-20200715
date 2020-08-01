package com.example.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author qianhao
 * @create 2020/7/16-23:45
 */
@Configuration
public class ApplicationContextConfig {

    @Bean(name = "restTemplate")
    @LoadBalanced //赋予RestTemplate负载均衡的实力
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
