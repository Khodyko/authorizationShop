package com.example.shop.controller;

import com.example.shop.entity.request.UrlRequest;
import com.example.shop.entity.response.list.UrlResponseList;
import com.example.shop.entity.response.mono.UrlResponseMono;
import com.example.shop.entity.simple.Url;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * This class used for work with Url entity, authentication and authorization.
 * //fixme entity names
 * It uses entity Url for getting data and ResponseURl for sending.
 *
 * @author Igor Khodyko
 * @see UrlResponseMono
 * @see UrlResponseList
 * @see Url
 */
@RequestMapping("/urls")
public interface UrlController {

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    Mono<UrlResponseList> getAllUrls();

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    Mono<UrlResponseMono> getUrlById(@PathVariable Long id);

    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<UrlResponseMono> saveUrl(@PathVariable UrlRequest urlFromWeb);

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    Mono<UrlResponseMono> putUrl(@PathVariable UrlRequest urlFromWeb);

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    void deleteUrlById(@PathVariable Long id);

}
