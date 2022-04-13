package com.example.shop.mapper;

import com.example.shop.entity.dtoEntity.UrlDto;
import com.example.shop.entity.requestEntity.UrlRequest;
import com.example.shop.entity.responseEntity.list.UrlResponseList;
import com.example.shop.entity.responseEntity.mono.UrlResponseMono;
import com.example.shop.entity.simpleEntity.Url;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(config = MapStructConfiguration.class)
public interface UrlMapper {
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
