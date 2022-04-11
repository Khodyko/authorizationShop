package com.example.shop.service;

import com.example.shop.entity.simpleEntity.Url;
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
   Flux<Url> allUrls();

   Mono<Url> getUrlById(Long id);

   Mono<Url> saveUrl(Url url);

   Mono<Url> putUrl(Url url);

   void deleteUserById(Long id);

}
