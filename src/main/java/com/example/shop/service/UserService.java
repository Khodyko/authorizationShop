package com.example.shop.service;

import com.example.shop.entity.simpleEntity.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class connected UserController and UserRepository(reactive)
 * realises business logic
 * //fixme write about entities
 *
 * @author Igor Khodyko
 */
public interface UserService {
    Flux<User> allUsers();

    Mono<User> getUserById(Long id);

    Mono<User> saveUser(User user);

    Mono<User> putUser(User user);

    void deleteUserById(Long id);
}
