package com.example.shop.repository.impl;

import com.example.shop.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;



public class UserRepositoryImpl {
//    private final R2dbcEntityTemplate template;
//    public Flux<User> findAll() {
//        return  this.template
//                .getDatabaseClient()
//                .sql("SELECT * FROM shop.user")
//                .map(row -> new User(row.get("id", Long.class),
//                        row.get("name", String.class),
//                "aaaa",
//                "aaaa",
//                "aaaa",
//                "aaaa",
//                "aaaa")).all();
//
//    }
}
