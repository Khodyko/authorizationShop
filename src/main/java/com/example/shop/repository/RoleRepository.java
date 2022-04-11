package com.example.shop.repository;

import com.example.shop.entity.simpleEntity.Role;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * This is Reactive Repository uses R2DBC API (NON-BLOCKED DBC)
 //fixme check Entities names
 * Uses Role entity
 * @see Role
 */
public interface RoleRepository extends ReactiveCrudRepository<Role, Long> {
}
