package com.server.authentication.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Slf4j
@Component
public class JwtProvider implements InitializingBean {

    private final String SECRET;
    private final long ACCESS_TOKEN_EXPIRE_TIME;
    private Key key;


    public JwtProvider(@Value("${jwt.secret}") String SECRET,
                       @Value("${jwt.access-expiration-time}") long accessTokenExpirationMilliseconds){
        this.SECRET = SECRET;
        this.ACCESS_TOKEN_EXPIRE_TIME = accessTokenExpirationMilliseconds;
    }

    @Override
    public void afterPropertiesSet() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    public String createAccessToken(String userId) {
        return createToken(userId, ACCESS_TOKEN_EXPIRE_TIME);
    }

    private String createToken(String userId, long time){
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + time);
        return Jwts.builder()
                .setSubject(userId)
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();

    }



}
