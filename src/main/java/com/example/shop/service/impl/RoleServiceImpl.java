package com.example.shop.service.impl;

import com.example.shop.entity.dto.RoleDto;
import com.example.shop.entity.simple.Role;
import com.example.shop.converter.RoleConverter;
import com.example.shop.repository.RoleRepository;
import com.example.shop.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;
    private final RoleConverter roleConverter;

    @Override
    public Flux<RoleDto> allRoles() {
        return roleRepository.findAll().map(roleConverter::roleToRoleDto)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<RoleDto> getRoleById(Long id) {
        return roleRepository.findById(id).map(roleConverter::roleToRoleDto)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<RoleDto> saveRole(RoleDto roleDtoInf) {
        Role roleInf = roleConverter.roleDtoToRole(roleDtoInf);
        return roleRepository.save(roleInf).map(roleConverter::roleToRoleDto)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<RoleDto> putRole(RoleDto roleDtoInf) {
        Role roleInf = roleConverter.roleDtoToRole(roleDtoInf);
        return roleRepository.save(roleInf).map(roleConverter::roleToRoleDto)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
