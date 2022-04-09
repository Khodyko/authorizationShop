package com.example.shop.repository;

import com.example.shop.entity.user.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * This is Reactive Repository uses R2DBC API (NON-BLOCKED DBC)
 //fixme check Entities names
 * Uses User entity
 * @see User
 */
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}
