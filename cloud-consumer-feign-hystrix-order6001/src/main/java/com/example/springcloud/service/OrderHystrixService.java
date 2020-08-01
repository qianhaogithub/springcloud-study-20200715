package com.example.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qianhao
 * @create 2020/7/26-15:20
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = OrderFallBackService.class)
public interface OrderHystrixService {

    @GetMapping("/hystrix/payment/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id);

    @GetMapping("/hystrix/payment/error/{id}")
    public String payment_error(@PathVariable("id") Integer id);

}

