package com.example.shop.security;

import com.example.shop.entity.simpleEntity.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private String expirationTime;

    public String extractUserName(String authToken) {

        return getClaimsFromToken(authToken)
                .getSubject();
    }

    public Claims getClaimsFromToken(String authToken) {
        String key=MD5Encoder.encode(secret.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(authToken)
                .getBody();
    }

    public boolean validateToken(String authToken) {
        return getClaimsFromToken(authToken)
                .getExpiration()
                .before(new Date());
    }

    public String generateToken(User user){
        HashMap<String, Object> claims=new HashMap<>();
        //fixme getRole
        claims.put("role", List.of(user.getRole()));
        Long expirationSeconds=Long.parseLong(expirationTime);
        Date creationDate=new Date();
        Date expirationDate= new Date(creationDate.getTime()+expirationSeconds*1000);
        return  Jwts.builder()
                .setClaims(claims)
                //id?
                .setSubject(user.getLogin())
                .setIssuedAt(creationDate)
                .setExpiration(expirationDate)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }
}
