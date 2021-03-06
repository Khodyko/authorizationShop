package com.example.shop.entity.simple;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.security.authentication.jaas.AuthorityGranter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Table(value = "shop.user")
@Data
public class User implements UserDetails {

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

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
//        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
//        List<SimpleGrantedAuthority> updatedAuthorities = new ArrayList<SimpleGrantedAuthority>();
//        updatedAuthorities.add(authority);
//        return updatedAuthorities;
        return null;
    }

    @Override
    public String getUsername() {
        return login;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
