package com.example.shop.entity.responseEntity.list;

import com.example.shop.entity.dtoEntity.UrlDto;
import com.example.shop.entity.dtoEntity.UserDto;
import lombok.Data;

import java.util.List;

@Data
public class UrlResponseList {
    //fixme check access to this entity
    private List<UrlDto> urls;

}
