package com.example.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author qianhao
 * @create 2020/7/30-22:43
 */
@Configuration
public class GateWayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //https://news.baidu.com/guonei
        RouteLocator path_route_payment1 = routes.route("path_route_payment1",
                r -> r.path("/guonei").uri("https://news.baidu.com")).build();
        return path_route_payment1;
    }

    @Bean
    public RouteLocator customRouteLocator1(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        //https://news.baidu.com/guonei
        RouteLocator path_route_payment1 = routes.route("path_route_payment1",
                r -> r.path("/guoji").uri("https://news.baidu.com")).build();
        return path_route_payment1;
    }
}
