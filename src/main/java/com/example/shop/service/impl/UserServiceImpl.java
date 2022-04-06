package com.example.shop.service.impl;

import com.example.shop.entity.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Flux<User> allUsers() {
        return userRepository.findAll();
    }
}
