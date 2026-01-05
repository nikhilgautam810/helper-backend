package com.helper_backend.security;

import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {

	@Value("${jwt.secret}")
	private String secret;

	private Key getSigningKey() {
		return Keys.hmacShaKeyFor(secret.getBytes(StandardCharsets.UTF_8));
	}

	private final long ACCESS_TOKEN_VALIDITY = 1000 * 60 * 15; // 15 minutes
	private final long REFRESH_TOKEN_VALIDITY = 1000 * 60 * 60 * 24 * 7; // 15 days

	public String generateAccessToken(String email) {
		return Jwts.builder().setSubject(email)
				.setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY))
				.signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
	}

	public String generateRefreshToken(String email) {
		return Jwts.builder().setSubject(email)
				.setExpiration(new Date(System.currentTimeMillis() + REFRESH_TOKEN_VALIDITY))
				.signWith(getSigningKey(), SignatureAlgorithm.HS256).compact();
	}

	public String extractUserName(String token) {
		return Jwts.parserBuilder().setSigningKey(getSigningKey()).build().parseClaimsJwt(token).getBody().getSubject();
	}

}
