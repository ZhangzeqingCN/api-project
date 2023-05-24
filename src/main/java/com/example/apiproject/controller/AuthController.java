package com.example.apiproject.controller;


import com.example.apiproject.domain.auth.LoginDomain;
import com.example.apiproject.domain.Result;
import com.example.apiproject.service.AuthService;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @NotNull
    public Result login(@RequestBody @NotNull LoginDomain loginDomain) {
        return authService.login(loginDomain);
    }

    @PostMapping("/register")
    @NotNull
    public Result register(@RequestBody @NotNull LoginDomain loginDomain) {
        return authService.login(loginDomain);
    }

}
