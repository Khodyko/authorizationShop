package com.example.shop.mapper;

import com.example.shop.entity.dtoEntity.RoleDto;
import com.example.shop.entity.requestEntity.RoleRequest;
import com.example.shop.entity.responseEntity.list.RoleResponseList;
import com.example.shop.entity.responseEntity.mono.RoleResponseMono;
import com.example.shop.entity.simpleEntity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);

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
