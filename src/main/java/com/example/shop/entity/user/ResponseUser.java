package com.example.shop.entity.user;

import lombok.Data;

import java.util.List;

@Data
public class ResponseUser {
    //fixme check access to this entity
    private List<User> users;
}
