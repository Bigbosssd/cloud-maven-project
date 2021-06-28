package com.example.controller;

import com.example.domain.User;
import com.example.feignclient.UserFeignClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/movies")
@RestController
public class MovieController {

    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping("/users/{id}")
    @HystrixCommand
    public User findById(@PathVariable("id") Long id) {
        return userFeignClient.findById(id);
    }
}