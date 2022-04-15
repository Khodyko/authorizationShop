package com.example.shop.security;

import com.example.shop.entity.simple.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.apache.tomcat.util.security.MD5Encoder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secret;
    @Value("${jwt.expiration}")
    private String expirationTime;

    public String extractUserLogin(String authToken) {

        return getClaimsFromToken(authToken)
                .getSubject();
    }
//fixme change encoding to md5
    public Claims getClaimsFromToken(String authToken) {
        String key= Base64.getEncoder().encodeToString(secret.getBytes());
//                MD5Encoder.encode(secret.getBytes());
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(authToken)
                .getBody();
    }

    public boolean validateToken(String authToken) {
        return  getClaimsFromToken(authToken)
                .getExpiration()
                .after(new Date());
    }

    public String generateToken(UserDetails user){
        Long expirationSeconds=Long.parseLong(expirationTime);
        Date creationDate=new Date();
        Date expirationDate= new Date(creationDate.getTime()+expirationSeconds*1000);
        return   Jwts.builder()
                .setSubject(user.getUsername())
                .setIssuedAt(creationDate)
                .setExpiration(expirationDate)
                .signWith(Keys.hmacShaKeyFor(secret.getBytes()))
                .compact();
    }
}
