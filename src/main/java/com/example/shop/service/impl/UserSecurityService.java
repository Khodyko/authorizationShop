package com.example.shop.service.impl;

import com.example.shop.entity.simpleEntity.Role;
import com.example.shop.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements ReactiveUserDetailsService {

    private final UserRepository userRepository;

    @Override
    public Mono<UserDetails> findByUsername(String login) {
        return userRepository.getUserByLogin(login)
                .cast(UserDetails.class);
    }

    public Flux<Role> findRolesByUserId(Long id){
        //fixme
        return null;
    }
}
