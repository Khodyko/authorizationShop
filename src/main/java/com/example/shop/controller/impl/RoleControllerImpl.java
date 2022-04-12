package com.example.shop.controller.impl;

import com.example.shop.controller.RoleController;
import com.example.shop.entity.dtoEntity.RoleDto;
import com.example.shop.entity.requestEntity.RoleRequest;
import com.example.shop.entity.responseEntity.list.RoleResponseList;
import com.example.shop.entity.responseEntity.mono.RoleResponseMono;
import com.example.shop.mapper.RoleMapper;
import com.example.shop.service.impl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class RoleControllerImpl implements RoleController {

    private final RoleServiceImpl roleService;
    private final RoleMapper mapper;

    @Override
    public Mono<RoleResponseList> getAllRoles() {
        return roleService.allRoles().collectList()
                .map(mapper.INSTANCE::roleDtoToRoleResponseList);
    }

    @Override
    public Mono<RoleResponseMono> getRoleById(Long id) {
        return roleService.getRoleById(id)
                .map(mapper.INSTANCE::roleDtoToRoleResponseMono);
    }

    //Fixme User without Id!!!
    @Override
    public Mono<RoleResponseMono> saveRole(RoleRequest roleRequest) {
        System.out.println(roleRequest);
        RoleDto roleDto = mapper.INSTANCE.roleRequestToRoleDto(roleRequest);
        System.out.println(roleDto);
        return roleService.saveRole(roleDto)
                .map(mapper.INSTANCE::roleDtoToRoleResponseMono);
    }

    @Override
    public Mono<RoleResponseMono> putRole(RoleRequest roleRequest) {
        RoleDto roleDto = mapper.INSTANCE.roleRequestToRoleDto(roleRequest);
        return roleService.saveRole(roleDto)
                .map(mapper.INSTANCE::roleDtoToRoleResponseMono);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleService.deleteRoleById(id);
    }
}
