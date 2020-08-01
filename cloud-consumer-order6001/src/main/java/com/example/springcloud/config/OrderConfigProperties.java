package com.example.springcloud.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @author qianhao
 * @create 2020/7/16-23:50
 */
@Data
@Component
    @ConfigurationProperties(prefix = "order.payment")
@PropertySource("classpath:config/order-microservice.properties")
public class OrderConfigProperties {

    private String prefixurl;
}
