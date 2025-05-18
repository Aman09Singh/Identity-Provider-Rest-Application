package com.restful.app.util;

import com.restful.app.model.UserDTO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.security.PrivateKey;
import java.util.Date;
import java.util.function.Function;

@Component
public class JWTUtil {

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;
    private Key signingKey;

    public String generateJWToken(UserDTO userDTO){


        return Jwts.builder()
                .setSubject(userDTO.getUserName())
                .claim("roles",userDTO.getAuthorities())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .signWith(signingKey)
                .compact();
    }

    @PostConstruct
    public void postCon(){
        this.signingKey =  new SecretKeySpec(SECRET_KEY.getBytes(),SignatureAlgorithm.HS256.getJcaName());
    }

}
