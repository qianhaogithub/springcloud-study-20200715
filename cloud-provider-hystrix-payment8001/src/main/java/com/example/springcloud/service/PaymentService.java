package com.example.springcloud.service;

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

/**
 * @author qianhao
 * @create 2020/7/21-0:14
 */
@Service
@Slf4j
public class PaymentService {

    public String paymentInfo_ok(Integer id){
        log.info("线程池：" + Thread.currentThread().getName() + "paymentinfo is ok,id=" + id);
        return "线程池：" + Thread.currentThread().getName() + "paymentinfo is ok,id=" + id;
    }

    @HystrixCommand(fallbackMethod = "paymentInfo_errorHandler",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "3000") //当前线程支持的最大响应时长
    })
    public String paymentInfo_error(Integer id){
        long time = 5;
        try {
            TimeUnit.SECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("线程池：" + Thread.currentThread().getName() + "-耗时：" + time +  "-paymentInfo_error,id=" + id);
        return "线程池：" + Thread.currentThread().getName() + "-耗时：" + time +  "-paymentInfo_error,id=" + id;
    }

    public String paymentInfo_errorHandler(Integer id){
        log.info("线程池：" + Thread.currentThread().getName() + "-系统繁忙或运行报错....." + "paymentInfo_errorHandler,id=" + id);
        return "线程池：" + Thread.currentThread().getName() + "-系统繁忙或运行报错....." + "paymentInfo_errorHandler,id=" + id;
    }

    //服务熔断
    @HystrixCommand(fallbackMethod = "paymentCircuitBreaker_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),  //是否开启断路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),   //请求总次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),  //时间范围
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60"), //失败率达到多少后跳闸
    })//10s范围内 10个访问请求失败次数达到6次以上
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException("*****id 不能负数");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"调用成功,流水号："+serialNumber;
    }
    public String paymentCircuitBreaker_fallback(@PathVariable("id") Integer id){
        return "id 不能负数，请稍候再试,(┬＿┬)/~~     id: " +id;
    }


}
