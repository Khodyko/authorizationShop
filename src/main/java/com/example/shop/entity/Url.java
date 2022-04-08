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
public class Url {
    @Id
    private Long id;
    private String url;
    @JoinTable
    private Set<Role> roles;
}
