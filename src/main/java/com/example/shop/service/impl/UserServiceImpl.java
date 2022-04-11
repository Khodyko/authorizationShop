package com.example.shop.service.impl;

import com.example.shop.entity.simpleEntity.User;
import com.example.shop.entity.dtoEntity.UserDto;
import com.example.shop.mapper.UserMapper;
import com.example.shop.repository.UserRepository;
import com.example.shop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public Flux<User> allUsers() {

      return userRepository.findAll();

    }

    public Mono<User> getUserById(Long id){
//        return userRepository.findById(id);
        return null;
    }

    public Mono<User> saveUser(User user){
//        return userRepository.save(user);
        return null;
    }


    public Mono<User> putUser(User user){
//        return userRepository.save(user);
        return null;
    }

    public void deleteUserById(Long id){
        System.out.println("!!!from serv"+id);
        userRepository.deleteById(id);

    }
}
