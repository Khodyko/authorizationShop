package com.example.shop.controller;

import com.example.shop.entity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface UserController {
    public Mono<List<User>> allUsers();
}
