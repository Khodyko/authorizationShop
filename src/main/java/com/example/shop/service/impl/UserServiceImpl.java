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
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Flux<UserDto> allUsers() {
      return userRepository.findAll().map(userMapper::userToUserDto)
              .subscribeOn(Schedulers.boundedElastic());
    }

    public Mono<UserDto> getUserById(Long id){
        return userRepository.findById(id).map(userMapper::userToUserDto)
                .subscribeOn(Schedulers.boundedElastic());
    }
    //inner script protection?
    //save->create
    public Mono<UserDto> saveUser(UserDto userDtoInf){
        User userInf=userMapper.INSTANCE.userDtoToUser(userDtoInf);
        return userRepository.save(userInf).map(userMapper::userToUserDto)
                .subscribeOn(Schedulers.boundedElastic());
    }


    public Mono<UserDto> putUser(UserDto userDtoInf){
        User userInf=userMapper.INSTANCE.userDtoToUser(userDtoInf);
        return userRepository.save(userInf).map(userMapper::userToUserDto)
                .subscribeOn(Schedulers.boundedElastic());
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
