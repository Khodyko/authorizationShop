package com.example.shop.entity.responseEntity;

import com.example.shop.entity.simpleEntity.User;
import lombok.Data;

import java.util.List;

@Data
public class RoleResponse {
    //fixme check access to this entity
    private List<User> users;
}
