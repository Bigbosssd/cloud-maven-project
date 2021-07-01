package com.example.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @PostMapping("/testPost")
    public void test(@RequestBody String jsonString) {
        System.out.println("jsonString" + jsonString);
    }
}
