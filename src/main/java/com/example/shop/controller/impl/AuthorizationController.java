package com.example.shop.controller.impl;

import com.example.shop.security.JwtUtil;
import com.example.shop.service.impl.UserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class AuthorizationController {

    private final static ResponseEntity<Object> UNAUTHORIZED = ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();

    private final UserSecurityService userSecurityService;
    private final JwtUtil jwtUtil;

    @PostMapping("/login")
    //add encoding
    public Mono<ResponseEntity> login(ServerWebExchange swe) {
        System.out.println("Post auth"+ swe.getFormData());
        return swe.getFormData().flatMap(credentials ->
                userSecurityService.findByUsername(credentials.getFirst("login"))
                        .cast(UserDetails.class)
                        .map(userDetails -> Objects.equals(
                                        credentials.getFirst("password"),
                                        userDetails.getPassword()
                                )
                                        ? ResponseEntity.ok(jwtUtil.generateToken(userDetails))
                                        : UNAUTHORIZED
                        )
                        .defaultIfEmpty(UNAUTHORIZED)
        );
    }
}
