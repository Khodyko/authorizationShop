package com.example.shop.controller.impl;

import com.example.shop.controller.UrlController;
import com.example.shop.entity.url.ResponseUrl;
import com.example.shop.entity.url.Url;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/urls")
@RequiredArgsConstructor
public class UrlControllerImpl implements UrlController {

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping
    @Override
    public Mono<ResponseUrl> getAllUrls() {
        return null;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @GetMapping("/{id}")
    @Override
    public Mono<ResponseUrl> getUrlById(@PathVariable Long id) {
        return null;
    }

    //Fixme User without Id!!!
    @ResponseStatus(code = HttpStatus.CREATED)
    @PostMapping
    @Override
    public Mono<ResponseUrl> saveUrl(@PathVariable Url urlFromWeb) {
        return null;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @PutMapping
    @Override
    public Mono<ResponseUrl> putUrl(@PathVariable Url urlFromWeb) {
        return null;
    }

    @ResponseStatus(code = HttpStatus.OK)
    @DeleteMapping("/{id}")
    @Override
    public void deleteUrlById(@PathVariable Long id) {

    }
}
