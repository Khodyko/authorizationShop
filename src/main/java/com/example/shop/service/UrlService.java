package com.example.shop.service;

import com.example.shop.entity.dto.UrlDto;
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
   Flux<UrlDto> allUrls();

   Mono<UrlDto> getUrlById(Long id);

   Mono<UrlDto> saveUrl(UrlDto url);

   Mono<UrlDto> putUrl(UrlDto url);

   void deleteUrlById(Long id);

}
