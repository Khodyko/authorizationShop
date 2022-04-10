package com.example.shop.entity.url;

import lombok.Data;

import java.util.List;

@Data
public class ResponseUrl {
    //fixme check access to this entity
    private List<Url> urls;
}
