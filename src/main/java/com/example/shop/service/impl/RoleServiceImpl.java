package com.example.shop.service.impl;

import com.example.shop.entity.simpleEntity.Role;
import com.example.shop.repository.RoleRepository;
import com.example.shop.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public Flux<Role> allRoles() {
        return roleRepository.findAll();
    }

    @Override
    public Mono<Role> getRoleById(Long id) {
        return roleRepository.findById(id);
    }

    @Override
    public Mono<Role> saveRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Mono<Role> putRole(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRoleById(Long id) {
            roleRepository.deleteById(id);
    }
}
