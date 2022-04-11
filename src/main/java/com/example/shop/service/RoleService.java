package com.example.shop.service;

import com.example.shop.entity.simpleEntity.Role;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class connected RoleController and RoleRepository(reactive)
 * realises business logic
 * //fixme write about entities
 *
 * @author Igor Khodyko
 */
public interface RoleService {
    Flux<Role> allRoles(); //TODO убери ненужные методы

    Mono<Role> getRoleById(Long id);

    Mono<Role> saveRole(Role role);

    Mono<Role> putRole(Role role);

    void deleteRoleById(Long id);
}
