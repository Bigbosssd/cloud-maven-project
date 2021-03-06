package com.example.feignclient;

import com.example.domain.User;
import com.example.feignclient.config.UserFeignConfig;
import com.example.feignclient.impl.UserFeignClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "provider-user",
        fallback = UserFeignClientImpl.class)
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}

