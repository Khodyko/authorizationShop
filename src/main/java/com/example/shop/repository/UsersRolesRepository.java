package com.example.shop.repository;

import com.example.shop.entity.simple.UsersRoles;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface UsersRolesRepository extends ReactiveCrudRepository<UsersRoles,Long> {
 Flux<UsersRoles> findAllByUserId(Long id);
 Flux<UsersRoles> findAllByRoleId(Long id);

}
