package com.example.shop.security;

import com.example.shop.service.impl.UserSecurityService;
import liquibase.pro.packaged.A;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AuthenticationFilter  {
    private final JwtUtil jwtUtil;
    private final UserSecurityService userSecurityService;

//    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {

        String path = exchange.getRequest().getURI().getPath();
        if(path.equals("/users")) {
            return Mono.empty();
        } else {
            return chain.filter(exchange);
        }
    }
}
