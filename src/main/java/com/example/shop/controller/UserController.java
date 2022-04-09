package com.example.shop.controller;

import com.example.shop.entity.user.ResponseUser;
import com.example.shop.entity.user.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import reactor.core.publisher.Mono;

/**
 *
 * This class used for work with Users data, authentication and authorization.
 //fixme entity names
 * It uses entity User for getting data and ResponseUser for sending.
 * @see ResponseUser
 * @see User
 * @author Igor Khodyko
 */
public interface UserController {

    @GetMapping
    Mono<ResponseUser> getAllUsers();

    @GetMapping
    Mono<ResponseUser> getUserById(Long id);

    @PostMapping
    Mono<ResponseUser> saveUser(User userFromWeb);

    @PutMapping
    Mono<ResponseUser> putUser(User userFromWeb);

    @DeleteMapping
    void deleteUserById(Long id);
}
