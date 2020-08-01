package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.UUID;

/**
 * @author qianhao
 * @create 2020/7/19-14:36
 */
@RestController
public class PaymentConsumerController {

    private final static String INVOKE_URL = "http://cloud-provider-payment";

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/consul")
    public String consulConsumer() {
        return restTemplate.getForObject(INVOKE_URL + "/payment/consulinfo",String.class);
    }
}
