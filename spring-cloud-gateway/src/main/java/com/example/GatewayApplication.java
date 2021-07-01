package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayApplication {
    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        String htpUri = "http://httpbin.org:80";
        return builder.routes()
                .route(predicateSpec -> predicateSpec
                        .path("/get")
                        .filters(filterSpec -> filterSpec
                                .addRequestHeader("Hello", "World")
                                .hystrix(config -> config
                                .setName("mycmd")
                                .setFallbackUri("forward:/fallback")))
                        .uri("http://httpbin.org:80")
//                ).route(predicateSpec -> predicateSpec.path()
                ).build();
    }
}
