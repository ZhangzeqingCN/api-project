package com.example.apiproject.utils;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.apiproject.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
@Slf4j
public class MyJwtUtil {
    private final Algorithm algorithm = Algorithm.HMAC256("secret");

    public String genToken(User user) {
        return createToken(user, 60 * 1000);
    }

    private static final String identityKey = "username";

    public String createToken(User user, int seconds) {
        return createToken(user, Calendar.SECOND, seconds);
    }

    public Optional<User> decodeToken(String token) {
        try {
            var verifier = JWT.require(algorithm).build();
            var jwt = verifier.verify(token);
            String username = jwt.getClaim(identityKey).asString();
            return Optional.of(User.builder().name(username).build());
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public String createToken(User user, int calendarField, int amount) {

        var calendar = Calendar.getInstance();
        var currentTime = calendar.getTime();
        calendar.add(calendarField, amount);
        var expirationTime = calendar.getTime();

        return JWT.create()
                .withSubject("authentication")
                .withIssuer("issuer")
                .withClaim(identityKey, user.getName())
                .withIssuedAt(currentTime)
                .withExpiresAt(expirationTime)
                .sign(algorithm);
    }
}