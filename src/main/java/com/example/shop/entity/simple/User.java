package com.example.shop.entity.simple;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Table(value = "shop.user")
@Data
public class User  {

    @Id
    @Column(value = "id")
    private Long id;
    @Column(value = "login")
    private String login;
    @Column(value = "password")
    @JsonIgnore
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
