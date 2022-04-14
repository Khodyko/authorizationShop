package com.example.shop.service;

import com.example.shop.entity.dto.UserDto;
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
    Flux<UserDto> allUsers();

    Mono<UserDto> getUserById(Long id);

    Mono<UserDto> saveUser(UserDto user);

    Mono<UserDto> putUser(UserDto user);

    void deleteUserById(Long id);
}
