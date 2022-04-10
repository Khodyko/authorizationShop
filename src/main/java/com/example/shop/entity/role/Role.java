package com.example.shop.entity.role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "shop.role")
public class Role {
    @Id
    @Column(value = "id")
    private Long id;
    @Column(value = "name")
    private String name;
}
