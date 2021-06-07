package com.example.controller;

import com.example.domain.User;
import com.example.feignclient.UserFeignClient;
import com.netflix.loadbalancer.RandomRule;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RequestMapping("/movies")
@RestController
public class MovieController {

    @Autowired
    UserFeignClient userFeignClient;

    @GetMapping("/users/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userFeignClient.findById(id);
    }

}