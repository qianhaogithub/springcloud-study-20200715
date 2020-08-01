package com.example.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @author qianhao
 * @create 2020/7/19-13:56
 */
@RestController
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping("/payment/consulinfo")
    public String paymentConsul() {
        return "Spring Cloud consul module:" + serverPort + "\n\t" + UUID.randomUUID();
    }
}
