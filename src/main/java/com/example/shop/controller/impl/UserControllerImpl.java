package com.example.shop.controller.impl;

import com.example.shop.controller.UserController;
import com.example.shop.entity.responseEntity.UserResponse;
import com.example.shop.entity.simpleEntity.User;
import com.example.shop.mapper.UserMapperImpl;
import com.example.shop.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserServiceImpl userServiceImpl;
    private final UserMapperImpl userMapper;

    @Override
    public Mono<UserResponse> getAllUsers() {
        List<User> users = userServiceImpl.allUsers().collectList().block(); //TODO убери блок и весь желтый текст ВЕЗДЕ (во всех классах)
        System.out.println(users.get(0));
        return null;
    }

    @Override
    public Mono<UserResponse> getUserById(Long id) {
        return null;
    }
    //Fixme User without Id!!!
    @Override
    public Mono<UserResponse> saveUser(User userFromWeb) {
        return null;
    }

    @Override
    public Mono<UserResponse> putUser(User userFromWeb) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        System.out.println("!!!"+id);
        userServiceImpl.deleteUserById(id);
    }
}
