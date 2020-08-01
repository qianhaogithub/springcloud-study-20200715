package com.example.springcloud.controller;

import com.example.springcloud.config.OrderConfigProperties;
import com.example.springcloud.entity.CommonResult;
import com.example.springcloud.entity.Payment;
import com.example.springcloud.lb.LoadBalance;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

/**
 * @author qianhao
 * @create 2020/7/16-23:41
 */
@RestController
@Slf4j
@RequestMapping("/orderconsumer/payment")
public class OrderController {

    @Autowired
    private OrderConfigProperties configProperties;
    @Autowired
    private RestTemplate restTemplate;
    /*@Autowired
    private LoadBalance loadBalance;
    @Autowired
    private DiscoveryClient discoveryClient;*/

    @GetMapping("/create")
    public CommonResult<Payment> create(Payment payment) {
        log.info(configProperties.toString());
        String url = configProperties.getPrefixurl() + "/payment/create";
        return restTemplate.postForObject(url,payment,CommonResult.class);
    }

    @GetMapping("/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable(name = "id") Long id){
        log.info(configProperties.getPrefixurl());
        String url = configProperties.getPrefixurl() + "/payment/" + id ;
        return restTemplate.getForObject(url,CommonResult.class);
    }

    @GetMapping("/getforentity/{id}")
    public CommonResult<Payment> getPaymentByIdForEntity(@PathVariable(name = "id") Long id){
        log.info(configProperties.getPrefixurl());
        String url = configProperties.getPrefixurl() + "/payment/" + id ;
        ResponseEntity<CommonResult> entity = restTemplate.getForEntity(url, CommonResult.class);
        if(!entity.getStatusCode().is2xxSuccessful()) {
            return new CommonResult<Payment>(400,"未查询到相关数据！");
        }
        return entity.getBody();
    }

    /*@RequestMapping(value = "/payment/lb")
    public String getPaymentLB() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(instances == null || instances.size() == 0) {
            return null;
        }
        ServiceInstance instances1 = loadBalance.instances(instances);
        URI uri = instances1.getUri();
        return restTemplate.getForObject(uri + "/payment/lb",String.class);
    }*/
}
