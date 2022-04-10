package com.example.shop.service.impl;

import com.example.shop.entity.url.Url;
import com.example.shop.repository.UrlRepository;
import com.example.shop.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;

    @Override
    public Flux<Url> allUrls() {
        return urlRepository.findAll();
    }

    @Override
    public Mono<Url> getUrlById(Long id) {
        return urlRepository.findById(id);
    }

    @Override
    public Mono<Url> saveUrl(Url url) {
        return urlRepository.save(url);
    }

    @Override
    public Mono<Url> putUrl(Url url) {
        return urlRepository.save(url);
    }

    @Override
    public void deleteUserById(Long id) {
        urlRepository.deleteById(id);
    }
}
