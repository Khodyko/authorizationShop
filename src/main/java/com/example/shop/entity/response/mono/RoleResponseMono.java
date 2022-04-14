package com.example.shop.entity.response.mono;

import com.example.shop.entity.dto.RoleDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleResponseMono {
    //fixme check access to this entity
    RoleDto roleDto;
}
