package com.tantao.springcloud.config;


import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator MyRouteLocator(RouteLocatorBuilder builder){

        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("my_route1", r -> r.path("/guonei")
                .uri("http://news.baidu.com/guonei"));
        return  routes.build();
    }

}
