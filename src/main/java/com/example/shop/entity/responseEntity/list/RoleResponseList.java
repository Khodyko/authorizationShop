package com.example.shop.entity.responseEntity.list;

import com.example.shop.entity.dtoEntity.RoleDto;
import com.example.shop.entity.simpleEntity.Role;
import com.example.shop.entity.simpleEntity.User;
import lombok.Data;

import java.util.List;

@Data
public class RoleResponseList {
    //fixme check access to this entity
    private List<RoleDto> roles;
}
