package com.example.shop.controller;

import com.example.shop.entity.url.ResponseUrl;
import com.example.shop.entity.url.Url;
import com.example.shop.entity.user.ResponseUser;
import com.example.shop.entity.user.User;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import reactor.core.publisher.Mono;

/**
 *
 * This class used for work with Url entity, authentication and authorization.
 //fixme entity names
 * It uses entity Url for getting data and ResponseURl for sending.
 * @see com.example.shop.entity.url.ResponseUrl
 * @see com.example.shop.entity.url.Url
 * @author Igor Khodyko
 */
public interface UrlController {

    @GetMapping
    Mono<ResponseUrl> getAllUrls();

    @GetMapping
    Mono<ResponseUrl> getUrlById(Long id);

    @PostMapping
    Mono<ResponseUrl> saveUrl(Url urlFromWeb);

    @PutMapping
    Mono<ResponseUrl> putUrl(Url urlFromWeb);

    @DeleteMapping
    void deleteUrlById(Long id);

}
