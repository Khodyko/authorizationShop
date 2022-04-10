package com.example.shop.service;

import com.example.shop.entity.role.Role;
import com.example.shop.entity.user.User;
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
    public Flux<Role> allRoles();

    public Mono<Role> getRoleById(Long id);

    public Mono<Role> saveRole(Role role);

    public Mono<Role> putRole(Role role);

    public void deleteRoleById(Long id);
}
