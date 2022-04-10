package com.example.shop.entity.role;

import com.example.shop.entity.user.User;
import lombok.Data;

import java.util.List;

@Data
public class ResponseRole {
    //fixme check access to this entity
    private List<User> users;
}
