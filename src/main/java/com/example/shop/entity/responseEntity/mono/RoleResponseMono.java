package com.example.shop.entity.responseEntity.mono;

import com.example.shop.entity.dtoEntity.RoleDto;
import com.example.shop.entity.simpleEntity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseMono {
    //fixme check access to this entity
    RoleDto roleDto;
}
