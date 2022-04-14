package com.example.shop.converter;

import com.example.shop.entity.dto.RoleDto;
import com.example.shop.entity.request.RoleRequest;
import com.example.shop.entity.response.list.RoleResponseList;
import com.example.shop.entity.response.mono.RoleResponseMono;
import com.example.shop.entity.simple.Role;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfiguration.class)
public interface RoleConverter {
    RoleDto roleToRoleDto(Role role);

    Role roleDtoToRole(RoleDto roleDto);

    Role roleRequestToRole(RoleRequest roleRequest);

    RoleDto roleRequestToRoleDto(RoleRequest roleRequest);

    default RoleResponseList roleDtoToRoleResponseList(List<RoleDto> roleDtoList) {
        RoleResponseList roleResponse = new RoleResponseList();
        roleResponse.setRoles(roleDtoList);

        return roleResponse;
    }

    default RoleResponseMono roleDtoToRoleResponseMono(RoleDto roleDto) {
        return new RoleResponseMono(roleDto);
    }

}
