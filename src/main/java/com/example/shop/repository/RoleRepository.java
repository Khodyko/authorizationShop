package com.example.shop.repository;

import com.example.shop.entity.role.Role;
import com.example.shop.entity.user.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * This is Reactive Repository uses R2DBC API (NON-BLOCKED DBC)
 //fixme check Entities names
 * Uses Role entity
 * @see com.example.shop.entity.role.Role
 */
public interface RoleRepository extends ReactiveCrudRepository<Role, Long> {
}
