package com.example.feignclient.impl;

import com.example.domain.User;
import com.example.feignclient.UserFeignClient;

import java.math.BigDecimal;

public class UserFeignClientFallback implements UserFeignClient {
    @Override
    public User findById(Long id) {
        return new User(id, "fallback用户", "fallback用户", 0, new BigDecimal(1));
    }
}
