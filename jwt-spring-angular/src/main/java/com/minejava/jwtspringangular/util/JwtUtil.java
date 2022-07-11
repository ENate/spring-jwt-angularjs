package com.minejava.jwtspringangular.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtUtil {
    private static final int TOKEN_VALIDITY = 3600 * 5;

    // Define secret key. For strong security, use random generation
    private static final String SECRET_KEY = "learn_programming_yourself";

    // Methods need to be accessible from different places


    public String getUsernameFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }
    // using functional programming via Function and T generic style
    // higher order functions via composition in Maths
    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }

    private Claims getAllClaimsFromToken(String token) {
        // SECRET KEY used to return value from token. Can also create a random secret key
        // Using random secret key creation makes the application 
        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUsernameFromToken(token);
        // check user name from token and that provided by user
        // check whether token is expired: using is
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private Boolean isTokenExpired(String token) {
        /**
         * @param: token
         * @returns claims from token
         * new date will return current date. Check dates of token.
         */
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }
    public Date getExpirationDateFromToken(String token) {
        /**
         * @param: token - 
         * @returns claims from token
         */
        return getClaimFromToken(token, Claims::getExpiration);
    }
    public String generateToken(UserDetails userDetails) {

        // This is used to generate tokens
        // Map contains claims but empty so that it takes sting as key and any object as val
        // use builder pattern to return jwt token
        Map<String, Object> claims = new HashMap<>();

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000))
                .signWith(SignatureAlgorithm.HS512, SECRET_KEY)
                .compact();
    }


    
}
