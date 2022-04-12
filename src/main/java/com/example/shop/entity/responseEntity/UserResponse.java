package com.example.shop.entity.responseEntity;

import com.example.shop.entity.dtoEntity.UserDto;
import com.example.shop.entity.simpleEntity.User;
import lombok.Data;

import java.util.List;

@Data
public class UserResponse {
    //fixme check access to this entity
    private List<UserDto> users;
}
