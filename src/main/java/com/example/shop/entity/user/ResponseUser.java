package com.example.shop.entity.user;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseUser {
    //fixme check access to this entity
    private List<User> users;
}
