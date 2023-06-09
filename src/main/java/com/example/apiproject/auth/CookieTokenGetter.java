package com.example.apiproject.auth;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Optional;

public class CookieTokenGetter implements TokenGetter {
    @NotNull
    @Override
    public Optional<String> getToken(@NotNull HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies == null || cookies.length == 0) {
            return Optional.empty();
        }
        return Arrays.stream(cookies).filter(cookie -> cookie.getValue().equals("token")).findFirst()
                .map(Cookie::getValue);
    }
}
