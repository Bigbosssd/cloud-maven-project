package com.example.controller;

import com.example.domain.User;
import com.example.feignclient.UserFeignHystrixClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.math.BigDecimal;

@RequestMapping("/movies")
@RestController
public class MovieController {

    @Autowired
    UserFeignHystrixClient userFeignHystrixClient;

    @GetMapping("/users/{id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User findById(@PathVariable("id") Long id) {
        return userFeignHystrixClient.findById(id);
    }

    public User findByIdFallback(Long id, Throwable throwable) {
        /* 此处可日志打印throwable */
        return new User(id, "默认用户", "默认用户", 0, new BigDecimal(1));
    }
}
