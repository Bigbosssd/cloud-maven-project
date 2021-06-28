package com.example.feignclient;

import com.example.domain.User;
import com.example.feignclient.impl.UserFeignHystrixClientImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "provider-user",
        fallback = UserFeignHystrixClientImpl.class)
public interface UserFeignHystrixClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}
