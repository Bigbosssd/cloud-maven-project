package com.example.feignclient.impl;

import com.example.domain.User;
import com.example.feignclient.UserFeignClient;
import java.math.BigDecimal;

public class UserFeignClientImpl implements UserFeignClient {
    @Override
    public User findById(Long id) {
        return new User((long)-1, "boom name", "生产者崩掉了", 0, new BigDecimal(1));
    }
}
