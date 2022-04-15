package com.example.shop.repository;

import com.example.shop.entity.simple.RolesUrls;
import com.example.shop.entity.simple.UsersRoles;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface RolesUrlsRepository extends ReactiveCrudRepository<RolesUrls,Long> {
    Flux<RolesUrls> findAllByUrlId(Long id);
}
