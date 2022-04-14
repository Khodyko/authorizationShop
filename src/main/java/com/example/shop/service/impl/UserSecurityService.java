package com.example.shop.service.impl;

import com.example.shop.entity.simple.Role;
import com.example.shop.entity.simple.User;
import com.example.shop.entity.simple.UsersRoles;
import com.example.shop.repository.RoleRepository;
import com.example.shop.repository.UserRepository;
import com.example.shop.repository.UsersRolesRepository;
import com.example.shop.security.UserAuth;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserSecurityService implements ReactiveUserDetailsService {

    private final UserRepository userRepository;
    private final UsersRolesRepository usersRolesRepository;
    private final RoleRepository roleRepository;

    @Override
    public Mono<UserDetails> findByUsername(String login) {

        Mono<User> user = userRepository.getUserByLogin(login);
        Flux<UsersRoles> usersRoles = usersRolesRepository.findAllByUserId(user);
        //fixme all blocks
//        List<Role> roles = usersRoles.stream().map(a -> (roleRepository.findById((a.getRoleId()))).block())
//                .collect(Collectors.toList());
//        List<String> roleNames=roles.stream().map(a->a.getName()).collect(Collectors.toList());
//        userAuth.setLogin(user.map(a->a.getLogin()).block());
//        userAuth.setPassword(user.map(a->a.getPassword()).block());
//        userAuth.setRoleNames(roleNames);
        Mono<UserAuth> userAuth = Mono.just(new UserAuth())
                .flatMap(a -> a.getLogin(user.flatMap()));
        return userAuth;
    }

    public Flux<Role> findRolesByUserId(Long id) {

        //fixme
        return null;
    }
}
