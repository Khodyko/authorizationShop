package com.example.shop.service;

import com.example.shop.entity.dto.RoleDto;
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
    Flux<RoleDto> allRoles(); //TODO убери ненужные методы

    Mono<RoleDto> getRoleById(Long id);

    Mono<RoleDto> saveRole(RoleDto role);

    Mono<RoleDto> putRole(RoleDto role);

    void deleteRoleById(Long id);
}
