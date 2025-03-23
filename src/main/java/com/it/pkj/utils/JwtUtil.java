package com.it.pkj.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.Getter;
import org.springframework.util.StringUtils;

import java.security.SecureRandom;
import java.util.*;

public class JwtUtil {
    /** 数字签名秘钥 */
    private String sighSecret = "";
    private final ObjectMapper objectMapper = new ObjectMapper();
    /** 令牌过期时间,默认30分钟 */
    @Getter
    private long expire = 30 * 60l;

    public JwtUtil(String secret, long expire) {
        this.sighSecret = secret;
        this.expire = expire;
    }

    public JwtUtil(String secret) {
        this.sighSecret = secret;
    }

    /** 生成令牌 */
    public String generateToken(String tid, Object userObject) {
        try {
            String userJson = objectMapper.writeValueAsString(userObject);
            Date now = new Date();
            Date expiration = new Date(now.getTime() + expire * 1000);

            return Jwts.builder()
                    .setSubject("login")
                    .setId(tid)
                    .setIssuedAt(now)
                    .setExpiration(expiration)
                    .claim("userObject", userJson)
                    .signWith(
                            Keys.hmacShaKeyFor(this.sighSecret.getBytes()),
                            SignatureAlgorithm.HS256
                    )
                    .compact();
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to serialize user object", e);
        }
    }
    /** 返回令牌的ID值 */
    public String parseToken(String token) {
        if (!StringUtils.hasText(token)) {
            throw new IllegalArgumentException("令牌不能为空!");
        }
        return Jwts.parserBuilder()
                // 设置验证令牌的秘钥
                .setSigningKey(Keys.hmacShaKeyFor(this.sighSecret.getBytes()))
                // 创建了令牌解析器
                .build()
                // 校验令牌
                .parseClaimsJws(token)
                .getBody()
                // 拿到令牌的Id(UUID)
                .getId();
    }

    public <T> T getUserObjectFromToken(String token, Class<T> clazz) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(Keys.hmacShaKeyFor(this.sighSecret.getBytes()))
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            String userJson = claims.get("userObject", String.class);
            if (userJson == null) {
                throw new RuntimeException("User object not found in JWT token");
            }
            return objectMapper.readValue(userJson, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Failed to deserialize user object", e);
        } catch (Exception e) {
            throw new RuntimeException("Failed to parse JWT token", e);
        }
    }
}
