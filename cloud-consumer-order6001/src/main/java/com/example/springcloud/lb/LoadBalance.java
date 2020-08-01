package com.example.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author qianhao
 * @create 2020/7/19-19:14
 */
public interface LoadBalance {

    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
