package com.example.shop.controller;

import com.example.shop.entity.requestEntity.UserRequest;
import com.example.shop.entity.responseEntity.UserResponse;
import com.example.shop.entity.simpleEntity.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 *
 * This class used for work with Users data, authentication and authorization.
 //fixme entity names
 * It uses entity User for getting data and ResponseUser for sending.
 * @see UserResponse
 * @see User
 * @author Igor Khodyko
 */
@RequestMapping("/users")
public interface UserController {
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    Mono<UserResponse> getAllUsers();

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    Mono<UserResponse> getUserById(@PathVariable Long id);

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    Mono<UserResponse> saveUser(@RequestBody UserRequest userRequest);

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping
    Mono<UserResponse> putUser(@RequestBody UserRequest userRequest);


    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    void deleteUserById(@PathVariable Long id);
}
