package com.example.shop.entity.responseEntity;

import com.example.shop.entity.simpleEntity.Url;
import lombok.Data;

import java.util.List;

@Data
public class UrlResponse {
    //fixme check access to this entity
    private List<Url> urls;
}
