package com.example.shop.converter;

import com.example.shop.entity.dto.UrlDto;
import com.example.shop.entity.request.UrlRequest;
import com.example.shop.entity.response.list.UrlResponseList;
import com.example.shop.entity.response.mono.UrlResponseMono;
import com.example.shop.entity.simple.Url;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfiguration.class)
public interface UrlConverter {
    UrlDto urlToUrlDto(Url url);

    Url urlDtoToUrl(UrlDto urlDto);

    Url urlRequestToUrl(UrlRequest urlRequest);

    UrlDto urlRequestToUrlDto(UrlRequest urlRequest);

    default UrlResponseList urlDtoToUrlResponseList(List<UrlDto> urlDtoList) {
        UrlResponseList UrlResponse = new UrlResponseList();
        UrlResponse.setUrls(urlDtoList);

        return UrlResponse;
    }

    default UrlResponseMono urlDtoToUrlResponseMono(UrlDto urlDto) {
        return new UrlResponseMono(urlDto);
    }

}
