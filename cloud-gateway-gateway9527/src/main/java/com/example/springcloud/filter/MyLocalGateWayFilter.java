package com.example.springcloud.filter;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Date;

/**
 * @author qianhao
 * @create 2020/7/31-23:06
 */
@Component
@Slf4j
public class MyLocalGateWayFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("******************come in GlobalGateWayFilter:" + DateUtil.format(new Date(),"yyyy-MM-dd HH24:mm:ss"));
        String uname = exchange.getRequest().getQueryParams().getFirst("uname");
        if(StrUtil.isBlank(uname)) {
            log.info("*******不合法的用户名：null**********");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete();
        }
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return 0;
    }
}
