package com.example.shop.service.impl;

import com.example.shop.entity.user.User;
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

    @Override
    public Flux<User> allUsers() {
        return userRepository.findAll();
    }

    public Mono<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public Mono<User> saveUser(User user){
        return userRepository.save(user);
    }

    public Mono<User> putUser(User user){
        return userRepository.save(user);
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
