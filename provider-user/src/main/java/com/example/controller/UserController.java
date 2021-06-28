package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @Value("${spring.profiles}")
    String profiles;

    @GetMapping("/{id}")
    public User findById(@PathVariable String id) {
        System.out.println("this is :" + profiles);
        return userService.findById(Long.parseLong(id));
    }
}