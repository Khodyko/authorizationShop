package com.example.shop.controller;

import com.example.shop.entity.request.UserRequest;
import com.example.shop.entity.response.list.UserResponseList;
import com.example.shop.entity.response.mono.UserResponseMono;
import com.example.shop.entity.simple.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * This class used for work with Users data, authentication and authorization.
 * //fixme entity names
 * It uses entity User for getting data and ResponseUser for sending.
 *
 * @author Igor Khodyko
 * @see UserResponseList
 * @see User
 */
@RequestMapping("/users")
public interface UserController {
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    Mono<UserResponseList> getAllUsers();

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    Mono<UserResponseMono> getUserById(@PathVariable Long id);

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<UserResponseMono> saveUser(@RequestBody UserRequest userRequest);

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<UserResponseMono> putUser(@RequestBody UserRequest userRequest);


    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    void deleteUserById(@PathVariable Long id);
}
