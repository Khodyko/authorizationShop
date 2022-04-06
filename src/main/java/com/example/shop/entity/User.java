package com.example.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;


import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    private Long id;
    private String login;
    private String password;
    private String passwordMd5;
    private String name;
    private String surname;
    private String patronymic;
}
