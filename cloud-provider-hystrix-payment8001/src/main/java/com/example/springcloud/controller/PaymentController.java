package com.example.springcloud.controller;

import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qianhao
 * @create 2020/7/21-0:19
 */
@RestController
@Slf4j
@RequestMapping("/hystrix")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverProt;

    @GetMapping("/payment/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id) {
        return paymentService.paymentInfo_ok(id);
    }

    @GetMapping("/payment/error/{id}")
    public String payment_error(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_error(id);
    }

    //===服务熔断
    @GetMapping("/payment/circuit/{id}")
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        String result = paymentService.paymentCircuitBreaker(id);
        log.info("*******result:"+result);
        return result;
    }
}
