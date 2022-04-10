package com.example.shop.controller.impl;

import com.example.shop.controller.RoleController;
import com.example.shop.entity.role.ResponseRole;
import com.example.shop.entity.role.Role;
import com.example.shop.service.impl.RoleServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleControllerImpl implements RoleController {

    private final RoleServiceImpl roleServiceImpl;

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    @Override
    public Mono<ResponseRole> getAllRoles() {
        return null;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    @Override
    public Mono<ResponseRole> getRoleById(@PathVariable Long id) {
        return null;
    }

    //Fixme User without Id!!!
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    @Override
    public Mono<ResponseRole> saveRole(@RequestBody Role roleFromWeb) {
        return null;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping
    @Override
    public Mono<ResponseRole> putRole(@RequestBody Role roleFromWeb) {
        return null;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    @Override
    public void deleteRoleById(@PathVariable Long id) {

    }
}
