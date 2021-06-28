package com.example.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HystrixController {
    @GetMapping("")
    public String index() {
        return "forward:/hystrix";
    }
}
