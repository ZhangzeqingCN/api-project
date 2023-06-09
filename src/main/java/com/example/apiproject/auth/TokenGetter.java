package com.example.apiproject.auth;

import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;

import java.util.Optional;

public interface TokenGetter {
    @NotNull
    Optional<String> getToken(@NotNull HttpServletRequest request);
}
