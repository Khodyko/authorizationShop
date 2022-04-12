package com.example.shop.service.impl;

import com.example.shop.entity.dtoEntity.RoleDto;
import com.example.shop.entity.simpleEntity.Role;
import com.example.shop.mapper.RoleMapper;
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
    private final RoleMapper roleMapper;

    @Override
    public Flux<RoleDto> allRoles() {
        return roleRepository.findAll().map(role ->
                roleMapper.INSTANCE.roleToRoleDto(role));
    }

    @Override
    public Mono<RoleDto> getRoleById(Long id) {
        return roleRepository.findById(id).map(roleMapper.INSTANCE::roleToRoleDto);
    }

    @Override
    public Mono<RoleDto> saveRole(RoleDto roleDtoInf) {
        Role roleInf = roleMapper.INSTANCE.roleDtoToRole(roleDtoInf);
        return roleRepository.save(roleInf).map(roleMapper.INSTANCE::roleToRoleDto);
    }

    @Override
    public Mono<RoleDto> putRole(RoleDto roleDtoInf) {
        Role roleInf = roleMapper.INSTANCE.roleDtoToRole(roleDtoInf);
        return roleRepository.save(roleInf).map(roleMapper.INSTANCE::roleToRoleDto);
    }

    @Override
    public void deleteRoleById(Long id) {
        roleRepository.deleteById(id);
    }
}
