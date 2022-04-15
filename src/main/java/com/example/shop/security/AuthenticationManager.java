package com.example.shop.security;

import com.example.shop.entity.simple.Role;
import com.example.shop.entity.simple.RolesUrls;
import com.example.shop.entity.simple.Url;
import com.example.shop.entity.simple.User;
import com.example.shop.repository.RolesUrlsRepository;
import com.example.shop.repository.UrlRepository;
import com.example.shop.service.RoleService;
import com.example.shop.service.impl.UserSecurityService;
import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.security.authentication.ReactiveAuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AuthenticationManager implements ReactiveAuthenticationManager {

    private final JwtUtil jwtUtil;
    private final UserSecurityService userSecurityService;
    private final RoleService roleService;
    private final UrlRepository urlRepository;
    private final RolesUrlsRepository rolesUrlsRepository;


    @Override
    public Mono<Authentication> authenticate(Authentication authentication) {
        String authToken = authentication.getCredentials().toString();
        String userLogin;

        try {
            userLogin = jwtUtil.extractUserLogin(authToken);
            System.out.println(userLogin);
        } catch (Exception e) {
            userLogin = null;
            System.out.println(e);
        }
//        System.out.println("authManager " + jwtUtil.validateToken(authToken));
        if (userLogin != null && jwtUtil.validateToken(authToken)) {
            String path = authentication.getDetails().toString();
            Flux<Role> roleOfUser=userSecurityService.findByUsername(userLogin).cast(User.class)
                    .flatMapMany(user -> userSecurityService.findRolesByUserId(user.getId()));
            Mono<Url> url=urlRepository.findUrlByUrl(path);
            Flux<RolesUrls> rolesUrls= url.flatMapMany(a->rolesUrlsRepository.findAllByUrlId(a.getId()));

//            Claims claims = jwtUtil.getClaimsFromToken(authToken);



            List<String> role = new ArrayList<>();
            role.add("ROLE_ADMIN");
            List<SimpleGrantedAuthority> authorities = role.stream()
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());

            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    userLogin, null, authorities);

            return Mono.just(authenticationToken);
        } else {
            return Mono.empty();
        }
    }
}
