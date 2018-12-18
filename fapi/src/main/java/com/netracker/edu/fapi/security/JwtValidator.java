package com.netracker.edu.fapi.security;

import com.netracker.edu.fapi.model.JwtUser;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtValidator {


    private String secret = "youtube";

    public JwtUser validate(String token) {
        JwtUser jwtUser = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
            System.out.println("expiration"+body.getExpiration());
                jwtUser = new JwtUser();
                jwtUser.setUsername(body.getSubject());
                jwtUser.setPassword((String) body.get("username"));
                jwtUser.setRole((String) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return jwtUser;
        }
    }
