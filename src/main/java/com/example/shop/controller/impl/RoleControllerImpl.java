package com.example.shop.controller.impl;

import com.example.shop.controller.RoleController;
import com.example.shop.entity.simpleEntity.Role;
import com.example.shop.entity.responseEntity.RoleResponse;
import com.example.shop.service.impl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class RoleControllerImpl implements RoleController {

    private final RoleServiceImpl roleServiceImpl;

    @Override
    public Mono<RoleResponse> getAllRoles() {
        return null;
    }

    @Override
    public Mono<RoleResponse> getRoleById(Long id) {
        return null;
    }

    //Fixme User without Id!!!
    @Override
    public Mono<RoleResponse> saveRole(Role roleFromWeb) {
        return null;
    }

    @Override
    public Mono<RoleResponse> putRole(Role roleFromWeb) {
        return null;
    }

    @Override
    public void deleteRoleById(Long id) {
    }
}
