package com.example.shop.repository;

import com.example.shop.entity.simple.Url;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

public interface UrlRepository extends ReactiveCrudRepository<Url, Long> {
    Mono<Url> findUrlByUrl(String url);
}
