package com.example.shop.repository;

import com.example.shop.entity.simpleEntity.UsersRoles;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UsersRolesRepository extends ReactiveCrudRepository<UsersRoles,Long> {
}
