package com.example.feignclient.impl;

import com.example.domain.User;
import com.example.feignclient.UserFeignClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class UserFeignClientFallbackFactory implements FallbackFactory<UserFeignClient> {
    @Override
    public UserFeignClient create(Throwable throwable) {
        return new UserFeignClient() {
            @Override
            public User findById(Long id) {
                // 在此处可日志输出throwable，查看短路原因
                return new User(id, "fallback用户", "fallback用户", 0, new BigDecimal(1));
            }
        };
    }
}
