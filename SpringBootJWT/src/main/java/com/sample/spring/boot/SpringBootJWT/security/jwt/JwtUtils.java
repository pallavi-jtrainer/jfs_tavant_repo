package com.sample.spring.boot.SpringBootJWT.security.jwt;

import java.security.Key;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.stereotype.Component;
import org.springframework.web.util.WebUtils;

import com.sample.spring.boot.SpringBootJWT.security.services.UserDetailsImpl;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class JwtUtils {
	private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
	
	@Value("${springbootjwt.app.jwt.secret}")
	private String jwtSecret;
	
	@Value("${springbootjwt.app.jwt.expirationms}")
	private int jwtExpirationMs;
	
	@Value("${springbootjwt.app.jwt.cookiename}")
	private String jwtCookieName;
	
	public String getJwtFromCookies(HttpServletRequest req) {
		Cookie cookie = WebUtils.getCookie(req, jwtCookieName);
		
		if(cookie != null) {
			return cookie.getValue();
		} else {
			return null;
		}
	}
	
	public ResponseCookie generateJwtCookie(UserDetailsImpl principleUser) {
		String jwt = generateTokenFromUserName(principleUser.getUsername());
		
		ResponseCookie cookie = ResponseCookie.from(jwtCookieName, jwt)
				.path("/api")
				.build();
		return cookie;
	}
	
	private Key key() {
		return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
	}
	
	public String generateTokenFromUserName(String username) {
		return Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(new Date(System.currentTimeMillis() + jwtExpirationMs * 1000))
				.signWith(key(), SignatureAlgorithm.HS256)
				.compact();
	}
	
	
	public ResponseCookie getCleanJwtCookie() {
		ResponseCookie cookie = ResponseCookie.from(jwtCookieName, null)
				.path("/api")
				.maxAge(24 * 60 * 60)
				.httpOnly(true)
				.build();
		return cookie;
	}
	
	public String getUserNameFromJwtToken(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(key())
				.build()
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
	}
	
	public boolean validateJwtToken(String authToken) {
		try {
			Jwts.parserBuilder()
				.setSigningKey(key())
				.build()
				.parse(authToken);
			return true;
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT Token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("Expired JWT Token: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT Token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT Claims string is empty: {}", e.getMessage());
		}
		
		return false;
	}
}
