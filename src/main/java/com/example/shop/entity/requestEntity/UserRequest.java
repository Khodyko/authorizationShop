package com.example.shop.entity.requestEntity;

import lombok.Data;

@Data
public class UserRequest {
    private Long id;
    private String login;
    private String password;
    private String passwordMd5;
    private String name;
    private String surname;
    private String patronymic;
}
