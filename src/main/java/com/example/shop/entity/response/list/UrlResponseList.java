package com.example.shop.entity.response.list;

import com.example.shop.entity.dto.UrlDto;
import lombok.Data;

import java.util.List;

@Data
public class UrlResponseList {
    //fixme check access to this entity
    private List<UrlDto> urls;

}
