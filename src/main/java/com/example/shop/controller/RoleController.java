package com.example.shop.controller;

import com.example.shop.entity.request.RoleRequest;
import com.example.shop.entity.response.list.RoleResponseList;
import com.example.shop.entity.response.mono.RoleResponseMono;
import com.example.shop.entity.simple.Role;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * This class used for work with Role data for authentication and authorization.
 * //fixme entity names
 * It uses entity Role for getting data and ResponseRole for sending.
 *
 * @author Igor Khodyko
 * @see Role
 * @see RoleResponseList
 */
@RequestMapping("/roles")
public interface RoleController {
    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    Mono<RoleResponseList> getAllRoles();

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    Mono<RoleResponseMono> getRoleById(@PathVariable Long id);

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<RoleResponseMono> saveRole(@RequestBody RoleRequest roleRequest);

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<RoleResponseMono> putRole(@RequestBody RoleRequest roleRequest);

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    void deleteRoleById(@PathVariable Long id);
}
