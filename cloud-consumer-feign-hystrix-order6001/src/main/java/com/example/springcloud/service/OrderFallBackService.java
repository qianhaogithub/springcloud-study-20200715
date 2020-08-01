package com.example.springcloud.service;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author qianhao
 * @create 2020/7/27-23:06
 */
@Component
public class OrderFallBackService implements  OrderHystrixService {

    @Override
    public String payment_ok(Integer id) {
        return "-----order_payment_ok fallback.....";
    }

    @Override
    public String payment_error(Integer id) {
        return "-----order_payment_error fallback.....";
    }
}
