package com.example.shop.security;

import com.example.shop.entity.simple.User;
import com.example.shop.service.impl.UserSecurityService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {

    private final JwtUtil jwtUtil;
    private final UserSecurityService userSecurityService;

    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String authToken = authentication.getCredentials().toString();
        String userLogin;
        try {
            userLogin = jwtUtil.extractUserLogin(authToken);
        } catch (Exception e) {
            userLogin = null;
            System.out.println(e);
        }
        if (userLogin != null && jwtUtil.validateToken(authToken)) {
//            Claims claims = jwtUtil.getClaimsFromToken(authToken);
//            List<String> roles = claims.get("role", List.class);
            User user=userSecurityService.findByUsername(userLogin).cast(User.class).block();
            List<SimpleGrantedAuthority> authorities =userSecurityService.findRolesByUserId(user.getId())
                    .map(role->new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList()).block();
//                    roles.stream().map(SimpleGrantedAuthority::new)
//                    .collect(Collectors.toList());
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userLogin, null, authorities
            );
            return Mono.just(authenticationToken);
        } else {
            return Mono.empty();
        }
    }
}
