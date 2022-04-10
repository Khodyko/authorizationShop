package com.example.shop.service;

import com.example.shop.entity.url.Url;
import com.example.shop.entity.user.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * This class connected UrlController and UrlRepository(reactive)
 * realises business logic
 * //fixme write about entities
 *
 * @author Igor Khodyko
 */
public interface UrlService {
    public Flux<Url> allUrls();

    public Mono<Url> getUrlById(Long id);

    public Mono<Url> saveUrl(Url url);

    public Mono<Url> putUrl(Url url);

    public void deleteUserById(Long id);

}
