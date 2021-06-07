package com.example.feignclient;

import com.example.domain.User;
import com.example.feignclient.config.UserFeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "provider-user"/*, configuration = UserFeignConfig.class*/)
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}

