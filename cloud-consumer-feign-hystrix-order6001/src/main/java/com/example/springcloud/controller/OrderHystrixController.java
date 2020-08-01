package com.example.springcloud.controller;

import com.example.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qianhao
 * @create 2020/7/26-15:28
 */
@RestController
@Slf4j
@RequestMapping("/hystrix/order")
@DefaultProperties(defaultFallback = "globalErrorHandler")
public class OrderHystrixController {

    @Autowired
    private OrderHystrixService orderHystrixService;

    @GetMapping("/ok/{id}")
    public String payment_ok(@PathVariable("id") Integer id) {
        return orderHystrixService.payment_ok(id);
    }

    @GetMapping("/error/{id}")
    /*@HystrixCommand(fallbackMethod = "payment_error_defauleHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000") //当前线程支持的最大响应时长
    })*/
    @HystrixCommand
    public String payment_error(@PathVariable("id") Integer id){
        return orderHystrixService.payment_error(id);
    }

    public String payment_error_defauleHandler(@PathVariable("id") Integer id){
        return "服务响应超时或报错.............";
    }

    public String globalErrorHandler() {
        return "通用异常处理，服务调用异常了！";
    }
}
