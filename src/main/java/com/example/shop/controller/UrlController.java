package com.example.shop.controller;

import com.example.shop.entity.simpleEntity.Url;
import com.example.shop.entity.responseEntity.UrlResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * This class used for work with Url entity, authentication and authorization.
 * //fixme entity names
 * It uses entity Url for getting data and ResponseURl for sending.
 *
 * @author Igor Khodyko
 * @see UrlResponse
 * @see Url
 */
@RequestMapping("/urls")
public interface UrlController {

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    Mono<UrlResponse> getAllUrls();

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    Mono<UrlResponse> getUrlById(@PathVariable Long id);

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    Mono<UrlResponse> saveUrl(@PathVariable Url urlFromWeb);

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping
    Mono<UrlResponse> putUrl(@PathVariable Url urlFromWeb);

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    void deleteUrlById(@PathVariable Long id);

}
