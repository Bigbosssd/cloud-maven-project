package com.example.service;

import com.example.domain.User;
import com.example.mapper.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id);
    }
}
