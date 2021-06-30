package com.example.service;

import com.example.domain.User;
import com.example.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public interface UserService {
    User findById(Long id);
}
