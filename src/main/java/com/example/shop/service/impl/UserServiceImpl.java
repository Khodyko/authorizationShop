package com.example.shop.service.impl;

import com.example.shop.entity.dto.UserDto;
import com.example.shop.entity.simple.User;
import com.example.shop.converter.UserConverter;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserConverter userConverter;

    @Override
    public Flux<UserDto> allUsers() {
        return userRepository.findAll().map(userConverter::userToUserDto)
                .subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<UserDto> getUserById(Long id) {
        return userRepository.findById(id).map(userConverter::userToUserDto)
                .subscribeOn(Schedulers.boundedElastic());
    }

    //inner script protection?
    //save->create
    public Mono<UserDto> saveUser(UserDto userDtoInf) {
        User userInf = userConverter.userDtoToUser(userDtoInf);
        return userRepository.save(userInf).map(userConverter::userToUserDto)
                .subscribeOn(Schedulers.boundedElastic());
    }


    public Mono<UserDto> putUser(UserDto userDtoInf) {
        User userInf = userConverter.INSTANCE.userDtoToUser(userDtoInf);
        return userRepository.save(userInf).map(userConverter::userToUserDto)
                .subscribeOn(Schedulers.boundedElastic());
    }

    public void deleteUserById(Long id) {
        userRepository.deleteById(id);
    }
}
