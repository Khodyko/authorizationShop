package com.example.shop.controller.impl;

import com.example.shop.controller.UserController;
import com.example.shop.entity.User;
import com.example.shop.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserControllerImpl implements UserController {

    private final UserServiceImpl userServiceImpl;

    @Autowired
    public UserControllerImpl(UserServiceImpl userServiceImpl) {
        this.userServiceImpl = userServiceImpl;
    }

@ResponseStatus(code= HttpStatus.OK)
    @GetMapping
    @Override
    public ResponseEntity allUsers() {
        System.out.println("users!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!1");
        List<User> users = userServiceImpl.allUsers().collectList().block();
        System.out.println(users.get(0));
        return new ResponseEntity(HttpStatus.OK);
    }
}
