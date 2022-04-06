package com.example.shop.service;

import com.example.shop.entity.User;
import reactor.core.publisher.Flux;

import java.util.List;

public interface UserService {
    public Flux<User> allUsers();
}
