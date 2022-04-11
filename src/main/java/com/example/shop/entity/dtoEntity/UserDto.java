package com.example.shop.entity.dtoEntity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


@Data
public class UserDto {
    private Long id;
    private String login;
    private String password;
    private String passwordMd5;
    private String name;
    private String surname;
    private String patronymic;


}
