package com.example.shop.controller.impl;

import com.example.shop.controller.UserController;
import com.example.shop.entity.user.ResponseUser;
import com.example.shop.entity.user.User;
import com.example.shop.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserServiceImpl userServiceImpl;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping @Override
    public Mono<ResponseUser> getAllUsers() {
        List<User> users = userServiceImpl.allUsers().collectList().block();
        System.out.println(users.get(0));
        return null;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping( "/{id}") @Override
    public Mono<ResponseUser> getUserById(@PathVariable Long id) {
        return null;
    }

    //Fixme User without Id!!!
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping @Override
    public Mono<ResponseUser> saveUser(@RequestBody User userFromWeb) {
        return null;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping @Override
    public Mono<ResponseUser> putUser(@RequestBody User userFromWeb) {
        return null;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}") @Override
    public void deleteUserById(Long id) {
    }
}
