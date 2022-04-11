package com.example.shop.controller;


import com.example.shop.entity.simpleEntity.Role;
import com.example.shop.entity.responseEntity.RoleResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * This class used for work with Role data for authentication and authorization.
 * //fixme entity names
 * It uses entity Role for getting data and ResponseRole for sending.
 *
 * @author Igor Khodyko
 * @see Role
 * @see RoleResponse
 */
@RequestMapping("/roles")
public interface RoleController {
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    Mono<RoleResponse> getAllRoles();

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    Mono<RoleResponse> getRoleById(@PathVariable Long id);

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    Mono<RoleResponse> saveRole(@RequestBody Role roleFromWeb);

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping
    Mono<RoleResponse> putRole(@RequestBody Role roleFromWeb);

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    void deleteRoleById(@PathVariable Long id);
}
