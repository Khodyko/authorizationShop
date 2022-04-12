package com.example.shop.service.impl;

import com.example.shop.entity.dtoEntity.UserDto;
import com.example.shop.entity.simpleEntity.User;
import com.example.shop.mapper.UserMapper;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Flux<UserDto> allUsers() {
      return userRepository.findAll().map(user -> UserMapper.INSTANCE
              .userToUserDto(user));
    }

    public Mono<UserDto> getUserById(Long id){
        return userRepository.findById(id).map(user -> UserMapper.INSTANCE
                .userToUserDto(user));
    }
    //inner script protection?
    public Mono<UserDto> saveUser(User userInf){
        return userRepository.save(userInf).map(user -> UserMapper.INSTANCE
                .userToUserDto(user));
    }


    public Mono<UserDto> putUser(User userInf){
        return userRepository.save(userInf).map(user -> UserMapper.INSTANCE
                .userToUserDto(user));
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);

    }
}
