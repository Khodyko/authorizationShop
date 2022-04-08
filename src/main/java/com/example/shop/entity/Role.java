package com.example.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import javax.persistence.JoinTable;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table
public class Role {
    @Id
    private Long id;
    private String name;
    @JoinTable
    private Set<User> users;
    @JoinTable
    private Set<Url> urls;


}