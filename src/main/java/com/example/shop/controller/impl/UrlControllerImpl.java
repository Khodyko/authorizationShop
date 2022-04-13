package com.example.shop.controller.impl;

import com.example.shop.controller.UrlController;
import com.example.shop.entity.dtoEntity.UrlDto;
import com.example.shop.entity.requestEntity.UrlRequest;
import com.example.shop.entity.responseEntity.list.UrlResponseList;
import com.example.shop.entity.responseEntity.mono.UrlResponseMono;
import com.example.shop.mapper.UrlMapper;
import com.example.shop.service.impl.UrlServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class UrlControllerImpl implements UrlController {

    private final UrlServiceImpl urlService;
    private final UrlMapper mapper;

    @Override
    public Mono<UrlResponseList> getAllUrls() {
        return urlService.allUrls().collectList()
                .map(mapper::urlDtoToUrlResponseList);
    }

    @Override
    public Mono<UrlResponseMono> getUrlById(Long id) {

        return urlService.getUrlById(id)
                .map(mapper::urlDtoToUrlResponseMono);
    }

    //Fixme User without Id!!!
    @Override
    public Mono<UrlResponseMono> saveUrl(UrlRequest urlRequest) {
        UrlDto urlDto=mapper.urlRequestToUrlDto(urlRequest);
        return urlService.saveUrl(urlDto)
                .map(mapper::urlDtoToUrlResponseMono);
    }

    @Override
    public Mono<UrlResponseMono> putUrl(UrlRequest urlRequest) {
        UrlDto urlDto=mapper.urlRequestToUrlDto(urlRequest);
        return urlService.saveUrl(urlDto)
                .map(mapper::urlDtoToUrlResponseMono);
    }

    @Override
    public void deleteUrlById(Long id) {
        urlService.deleteUrlById(id);
    }
}
