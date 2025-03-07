package utils;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;

public final class JwtUtil {

    public static final String creatToken(String serectKey, Map<String,Object> claims){
        Instant now = Instant.now();
        Duration duration = Duration.ofHours(12);
        Instant expiresAt = now.plus(duration);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(Date.from(expiresAt))
                .signWith(SignatureAlgorithm.HS256,serectKey.getBytes(StandardCharsets.UTF_8))
                .compact();
    }

    public static final Claims parseToken(String token ,String secretKey){
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8))
                .parseClaimsJws(token).getBody();
        return claims;
    }
}
