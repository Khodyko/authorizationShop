package com.example.shop.entity.response.list;

import com.example.shop.entity.dto.RoleDto;
import lombok.Data;

import java.util.List;

@Data
public class RoleResponseList {
    //fixme check access to this entity
    private List<RoleDto> roles;
}
