package com.example.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;


import javax.persistence.JoinTable;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "shop.url")
public class Url {
    @Id
    @Column(value="id")
    private Long id;
    @Column(value = "url")
    private String url;
}
