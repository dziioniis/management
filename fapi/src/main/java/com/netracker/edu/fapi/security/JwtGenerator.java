package com.netracker.edu.fapi.security;

import com.netracker.edu.fapi.model.JwtUser;
import com.netracker.edu.fapi.model.JwtUserDetails;
import com.netracker.edu.fapi.service.UserViewModelService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;
import java.util.Date;

@Component
public class JwtGenerator {
    @Autowired
    UserViewModelService userViewModelService;
    static final long ACCESS_EXPIRATION = 600_000;
    static final long REFRESH_EXPIRATION = 1000_000;

    public String generate(JwtUser jwtUser) {
        System.out.println(new Date(System.currentTimeMillis()+ACCESS_EXPIRATION));
            Claims claims = Jwts.claims()
                    .setSubject(jwtUser.getUsername());
            claims.put("username", String.valueOf(jwtUser.getUsername()));
            claims.put("role", jwtUser.getRole());
            return Jwts.builder()
                    .setClaims(claims)
                    .setExpiration(new Date(System.currentTimeMillis()+ACCESS_EXPIRATION))
                    .signWith(SignatureAlgorithm.HS512, "youtube")
                    .compact();
    }
    public String refreshToken(JwtUser jwtUser,String token) {
         Date createdDate = new Date(System.currentTimeMillis());
        final Claims claims = getAllClaimsFromToken(token);
        claims.setIssuedAt(createdDate);
        claims.setExpiration(new Date(System.currentTimeMillis()+REFRESH_EXPIRATION));
        claims.put("id",jwtUser.getId());
        return Jwts.builder()
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS512, "youtube")
                .compact();
    }

    private Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey("youtube")
                .parseClaimsJws(token)
                .getBody();
    }
}
