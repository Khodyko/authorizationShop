package com.example.shop.repository;


import com.example.shop.entity.user.UserDto;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

/**
 * This is Reactive Repository uses R2DBC API (NON-BLOCKED DBC)
 //fixme check Entities names
 * Uses DtoUser entity
 * @see UserDto
 */
public interface UserRepository extends ReactiveCrudRepository<UserDto, Long> {
}
