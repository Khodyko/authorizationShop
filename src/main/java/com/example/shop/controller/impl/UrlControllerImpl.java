package com.example.shop.controller.impl;

import com.example.shop.controller.UrlController;
import com.example.shop.entity.simpleEntity.Url;
import com.example.shop.entity.responseEntity.UrlResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UrlControllerImpl implements UrlController {


    @Override
    public Mono<UrlResponse> getAllUrls() {
        return null;
    }


    @Override
    public Mono<UrlResponse> getUrlById(Long id) {
        return null;
    }

    //Fixme User without Id!!!
    @Override
    public Mono<UrlResponse> saveUrl(Url urlFromWeb) {
        return null;
    }


    @Override
    public Mono<UrlResponse> putUrl(Url urlFromWeb) {
        return null;
    }


    @Override
    public void deleteUrlById(Long id) {

    }
}
