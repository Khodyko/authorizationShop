package com.example.shop.controller;


import com.example.shop.entity.role.ResponseRole;
import com.example.shop.entity.role.Role;
import com.example.shop.entity.user.ResponseUser;
import com.example.shop.entity.user.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 *
 * This class used for work with Role data for authentication and authorization.
 //fixme entity names
 * It uses entity Role for getting data and ResponseRole for sending.
 * @see com.example.shop.entity.role.Role
 * @see com.example.shop.entity.role.ResponseRole
 * @author Igor Khodyko
 */
public interface RoleController {
    @GetMapping
    Mono<ResponseRole> getAllRoles();

    @GetMapping
    Mono<ResponseRole> getRoleById(Long id);

    @PostMapping
    Mono<ResponseRole> saveRole(Role roleFromWeb);

    @PutMapping
    Mono<ResponseRole> putRole(Role roleFromWeb);

    @DeleteMapping
    void deleteRoleById(Long id);
}
