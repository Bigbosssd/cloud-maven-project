package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@EnableZuulProxy
@SpringBootApplication
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

//    @Bean
//    public PatternServiceRouteMapper serviceRouteMapper() {
//        // 调用构造函数PatternServiceRouteMapper(String servicePattern, String routePattern)
//        // servicePattern指定微服务的正则
//        // routePattern指定路由正则
//        // 通过这段代码即可实现将诸如microservice-provider-user-v1这个微服务，映射到/v1/microservice-provider-user/**这个路径。
//        return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
//    }
}
