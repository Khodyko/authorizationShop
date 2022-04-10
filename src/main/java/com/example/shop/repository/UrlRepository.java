package com.example.shop.repository;

import com.example.shop.entity.url.Url;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface UrlRepository extends ReactiveCrudRepository<Url, Long> {
}
