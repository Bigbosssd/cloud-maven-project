package com.example.mapper;

import com.example.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserRepository {
    User findById(Long Id);
}