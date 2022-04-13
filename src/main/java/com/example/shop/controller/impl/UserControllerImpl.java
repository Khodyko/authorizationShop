package com.example.shop.controller.impl;

import com.example.shop.controller.UserController;
import com.example.shop.entity.dtoEntity.UserDto;
import com.example.shop.entity.requestEntity.UserRequest;
import com.example.shop.entity.responseEntity.list.UserResponseList;
import com.example.shop.entity.responseEntity.mono.UserResponseMono;
import com.example.shop.mapper.UserMapper;
import com.example.shop.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserServiceImpl userService;
    private final UserMapper mapper;

    @Override
    public Mono<UserResponseList> getAllUsers() {
        return userService.allUsers().collectList()
                .map(mapper::userDtoToUserResponseList);
    }

    @Override
    public Mono<UserResponseMono> getUserById(Long id) {
        return userService.getUserById(id)
                .map(mapper::userDtoToUserResponseMono);
    }

    //Fixme User without Id!!!
    @Override
    public Mono<UserResponseMono> saveUser(UserRequest userRequest) {
        UserDto userDto= mapper.userRequestToUserDto(userRequest);
        return userService.saveUser(userDto)
                .map(mapper::userDtoToUserResponseMono);
    }

    @Override
    public Mono<UserResponseMono> putUser(UserRequest userRequest) {
        UserDto userDto= mapper.INSTANCE.userRequestToUserDto(userRequest);
        return userService.saveUser(userDto)
                .map(mapper::userDtoToUserResponseMono);
    }

    @Override
    public void deleteUserById(Long id) {
        userService.deleteUserById(id);
    }
}
