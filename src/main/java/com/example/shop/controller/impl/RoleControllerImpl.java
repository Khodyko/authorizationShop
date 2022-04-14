package com.example.shop.controller.impl;

import com.example.shop.controller.RoleController;
import com.example.shop.entity.dto.RoleDto;
import com.example.shop.entity.request.RoleRequest;
import com.example.shop.entity.response.list.RoleResponseList;
import com.example.shop.entity.response.mono.RoleResponseMono;
import com.example.shop.converter.RoleConverter;
import com.example.shop.service.impl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class RoleControllerImpl implements RoleController {

    private final RoleServiceImpl roleService;
    private final RoleConverter roleConverter;

    @Override
    public Mono<RoleResponseList> getAllRoles() {
        return roleService.allRoles().collectList()
                .map(roleConverter::roleDtoToRoleResponseList);
    }

    @Override
    public Mono<RoleResponseMono> getRoleById(Long id) {
        return roleService.getRoleById(id)
                .map(roleConverter::roleDtoToRoleResponseMono);
    }

    //Fixme User without Id!!!
    @Override
    public Mono<RoleResponseMono> saveRole(RoleRequest roleRequest) {
        System.out.println(roleRequest);
        RoleDto roleDto = roleConverter.roleRequestToRoleDto(roleRequest);
        System.out.println(roleDto);
        return roleService.saveRole(roleDto)
                .map(roleConverter::roleDtoToRoleResponseMono);
    }

    @Override
    public Mono<RoleResponseMono> putRole(RoleRequest roleRequest) {
        RoleDto roleDto = roleConverter.roleRequestToRoleDto(roleRequest);
        return roleService.saveRole(roleDto)
                .map(roleConverter::roleDtoToRoleResponseMono);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleService.deleteRoleById(id);
    }
}
