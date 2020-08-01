package com.example.springcloud.controller;

import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.Payment;
import com.example.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author qianhao
 * @create 2020/7/16-22:23
 */
@RestController
@Slf4j
@RequestMapping("/payment")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    public CommonResult<Payment> create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("处理结果：" + i);
        int code = i>0?200 : 404;
        String message = i>0? "处理成功，端口号：" + serverPort:"处理失败";
        return new CommonResult<>(code,message);
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(name = "id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询成功");
        log.info("Hello World!");
        if(payment!=null) {
            return new CommonResult<>(200,"查询成功,端口号：" + serverPort,payment);
        } else {
            return new CommonResult<>(404,"没有查找到对应的记录");
        }
    }

    @GetMapping(value = "/lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping(value = "/feign/timeout")
    public String paymentFeignTimeout() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }
}
