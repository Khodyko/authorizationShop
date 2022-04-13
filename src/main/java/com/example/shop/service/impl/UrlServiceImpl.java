package com.example.shop.service.impl;

import com.example.shop.entity.dtoEntity.UrlDto;
import com.example.shop.entity.simpleEntity.Url;
import com.example.shop.mapper.UrlMapper;
import com.example.shop.repository.UrlRepository;
import com.example.shop.service.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;

@Service
@RequiredArgsConstructor
public class UrlServiceImpl implements UrlService {

    private final UrlRepository urlRepository;
    private final UrlMapper urlMapper;

    @Override
    public Flux<UrlDto> allUrls() {
        return urlRepository.findAll().map(urlMapper::urlToUrlDto)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<UrlDto> getUrlById(Long id) {
        return urlRepository.findById(id).map(urlMapper::urlToUrlDto)
                .subscribeOn(Schedulers.boundedElastic());
    }

    //inner script protection?
    //save->create
    @Override
    public Mono<UrlDto> saveUrl(UrlDto urlDtoInf) {
        Url urlInf=urlMapper.urlDtoToUrl(urlDtoInf);
        return urlRepository.save(urlInf).map(urlMapper::urlToUrlDto)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public Mono<UrlDto> putUrl(UrlDto urlDtoInf) {
        Url urlInf=urlMapper.urlDtoToUrl(urlDtoInf);
        return urlRepository.save(urlInf).map(urlMapper::urlToUrlDto)
                .subscribeOn(Schedulers.boundedElastic());
    }

    @Override
    public void deleteUrlById(Long id) {
        urlRepository.deleteById(id);
    }
}
