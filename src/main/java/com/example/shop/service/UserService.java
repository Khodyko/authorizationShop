package com.example.shop.service;

import com.example.shop.entity.user.User;
import reactor.core.publisher.Flux;

public interface UserService {
    public Flux<User> allUsers();
}
