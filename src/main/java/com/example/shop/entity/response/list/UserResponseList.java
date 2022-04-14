package com.example.shop.entity.response.list;

import com.example.shop.entity.dto.UserDto;
import lombok.Data;

import java.util.List;

@Data
public class UserResponseList {
    //fixme check access to this entity
    private List<UserDto> users;
}
