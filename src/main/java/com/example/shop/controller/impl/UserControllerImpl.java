package com.example.shop.controller.impl;

import com.example.shop.controller.UserController;
import com.example.shop.entity.User;
import com.example.shop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController("/users")
public class UserControllerImpl implements UserController {

    private final UserServiceImpl userService;

    @Autowired
    public UserControllerImpl(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping
    @Override
    public Mono<List<User>> allUsers() {
        List<User> users=  userService.allUsers().collectList().block();
        return Mono.just(users);
    }
}
