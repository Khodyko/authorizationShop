package com.example.shop.controller.impl;

import com.example.shop.controller.UserController;
import com.example.shop.entity.requestEntity.UserRequest;
import com.example.shop.entity.responseEntity.UserResponse;
import com.example.shop.mapper.UserMapperImpl;
import com.example.shop.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserServiceImpl userServiceImpl;
    private final UserMapperImpl userMapper;

    @Override
    public Mono<UserResponse> getAllUsers() {
        Mono<UserResponse> userResponseMono = userServiceImpl.allUsers().collectList()
                .map(list -> userMapper.INSTANCE.userDtoToUserResponse(list));
        return userResponseMono;
    }

    @Override
    public Mono<UserResponse> getUserById(Long id) {
        Mono<UserResponse> userResponseMono = userServiceImpl.getUserById(id)
                .map(entity -> userMapper.INSTANCE.userDtoToUserResponse(entity));
        return userResponseMono;
    }

    //Fixme User without Id!!!
    @Override
    public Mono<UserResponse> saveUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public Mono<UserResponse> putUser(UserRequest userRequest) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {
        System.out.println("!!!" + id);
        userServiceImpl.deleteUserById(id);
    }
}
