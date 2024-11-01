package com.petstore.onlinepetstore.service;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.context.annotation.Configuration;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtUtils {
    private final Long EXPIRYTIME =36000000L;
    private final String SECRETKEY ="3d6cc6e04ef7d62e173415c8516abedfe997235afc46b1d3961b2788372fc7b327cf9d6f50a59ec0dc3938f0a3dfbeb48b63fd617e6cf15e7d27fb8c8a4ffed3a1a8709f089b95bfe0124b8fc28ccc4e12876a5c74967a9fbe734ea93cd67f5f9dcb6084ffe26badc86b6ef3bb072b69efe508bf9812737f9a1bd65c3aa126b5c3855096b6b10537d9ed185405a586425e4c831263c18c155110bd7064de3858089727b21691cd2f6baac5083d651c493cce85596192968851dc1ff47e3953110ecfcd7c4d821fecd43cd8d2020d17bfad53ad5780c80210d511e092b80ff9fb78425caa3a7d71f78f9dc2a763a56b6423076c7df8f7d738db72d2d57969559c";


    public String generateToken(String username) {
        Map<String,Object> claims =new HashMap<>();

        return Jwts.builder()
                .claims()
                .add(claims)
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .and()
                .expiration(new Date(System.currentTimeMillis()+ EXPIRYTIME))
                .signWith(generateSecretKey())
                .compact();

    }

    private Key generateSecretKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRETKEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
