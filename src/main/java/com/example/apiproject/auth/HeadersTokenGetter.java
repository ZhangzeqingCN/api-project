package com.example.apiproject.auth;

import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Component;

import java.util.Optional;

public class HeadersTokenGetter implements TokenGetter {
    @NotNull
    @Override
    public Optional<String> getToken(@NotNull HttpServletRequest request) {
        return Optional.ofNullable(request.getHeader("token"));
    }
}
