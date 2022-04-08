package com.example.shop.repository.impl;

import com.example.shop.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

@Component
@RequiredArgsConstructor
public class UserRepositoryImpl {
    private final R2dbcEntityTemplate template;
    public Flux<User> findAll() {
        return this.template.select(User.class).all();
    }
}
