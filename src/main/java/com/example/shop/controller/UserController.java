package com.example.shop.controller;

import com.example.shop.entity.user.ResponseUser;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

public interface UserController {
    public Mono<ResponseUser> getAllUsers();
}
