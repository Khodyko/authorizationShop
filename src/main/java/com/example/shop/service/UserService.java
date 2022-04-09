package com.example.shop.service;

import com.example.shop.entity.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class connected UserController and UserRepository
 * realises business logic
 * //fixme write about entities
 *
 * @author Igor Khodyko
 */
public interface UserService {
    public Flux<User> allUsers();

    public Mono<User> getUserById(Long id);

    public Mono<User> saveUser(User user);

    public Mono<User> putUser(User user);

    public void deleteUserById(Long id);
}
