package com.example.shop.entity.simpleEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(value = "shop.roles_urls")
public class RolesUrls {

    @Id
    @Column(value="id")
    private Long id;
    @Column(value = "role_id")
    private Long userId;
    @Column(value = "url_id")
    private Long roleId;
}
