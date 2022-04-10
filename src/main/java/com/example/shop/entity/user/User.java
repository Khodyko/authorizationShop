package com.example.shop.entity.user;

import lombok.Data;

@Data
public class User {


    private Long id;

    private String login;

    private String password;

    private String passwordMd5;

    private String name;

    private String surname;

    private String patronymic;
}
