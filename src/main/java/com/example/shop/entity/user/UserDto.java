package com.example.shop.entity.user;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "shop.user")
@Data
public class UserDto { //TODO создай пакеты для дто, ентити и реквест/респонсов, дто никак не связываются с таблицами
    @Id
    @Column(value = "id")
    private Long id;
    @Column(value = "login")
    private String login;
    @Column(value = "password")
    private String password;
    @Column(value="password_md5")
    private String passwordMd5;
    @Column(value = "name")
    private String name;
    @Column(value="surname")
    private String surname;
    @Column(value="patronymic")
    private String patronymic;
}