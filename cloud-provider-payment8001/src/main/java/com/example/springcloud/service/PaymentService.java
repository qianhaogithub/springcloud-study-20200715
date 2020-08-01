package com.example.springcloud.service;

import com.example.springcloud.entity.Payment;

/**
 * @author qianhao
 * @create 2020/7/16-22:17
 */
public interface PaymentService {

    int create(Payment payment);

    Payment getPaymentById(Long id);
}
