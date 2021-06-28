package com.example.feignclient;

import com.example.domain.User;
import com.example.feignclient.impl.UserFeignClientFallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "provider-user",
        // 可以选择使用fallback直接选择降级类
        /*fallback = UserFeignClientFallback.class*/

        // 也可以使用fallbackFactory，可以查看断路原因
        fallbackFactory = UserFeignClientFallbackFactory.class
)
public interface UserFeignClient {
    @GetMapping("/users/{id}")
    User findById(@PathVariable("id") Long id);
}

