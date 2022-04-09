package com.example.shop.service;

import com.example.shop.entity.user.User;
import reactor.core.publisher.Flux;

/**
 * This class connected UserController and UserRepository
 * realises business logic
 //fixme write about entities
 * @author Igor Khodyko
 */
public interface UserService {
    public Flux<User> allUsers();
}
