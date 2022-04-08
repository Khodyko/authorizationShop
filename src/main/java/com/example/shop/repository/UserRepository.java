package com.example.shop.repository;

import com.example.shop.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;



public interface UserRepository extends ReactiveCrudRepository<User, Long> {
}
