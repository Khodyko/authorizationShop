package com.example.shop.service.impl;

import com.example.shop.entity.User;
import com.example.shop.repository.UserRepository;
import com.example.shop.repository.impl.UserRepositoryImpl;
import com.example.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Flux<User> allUsers() {
        return userRepository.findAll();
    }
}
