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
      return userRepository.findAll().map(user -> userMapper.INSTANCE
              .userToUserDto(user));
    }

    public Mono<UserDto> getUserById(Long id){
        return userRepository.findById(id).map(user -> userMapper.INSTANCE
                .userToUserDto(user));
    }
    //inner script protection?
    //save->create
    public Mono<UserDto> saveUser(UserDto userDtoInf){
        User userInf=userMapper.INSTANCE.userDtoToUser(userDtoInf);
        return userRepository.save(userInf).map(user -> userMapper.INSTANCE
                .userToUserDto(user));
    }


    public Mono<UserDto> putUser(UserDto userDtoInf){
        User userInf=userMapper.INSTANCE.userDtoToUser(userDtoInf);
        return userRepository.save(userInf).map(user -> userMapper.INSTANCE
                .userToUserDto(user));
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
