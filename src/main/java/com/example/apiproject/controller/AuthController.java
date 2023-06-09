package com.example.apiproject.controller;


import com.example.apiproject.domain.Result;
import com.example.apiproject.domain.auth.LoginRequestBody;
import com.example.apiproject.domain.auth.RegisterRequestBody;
import com.example.apiproject.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    @NotNull
    public Result login(@RequestBody @NotNull LoginRequestBody loginRequestBody, HttpServletResponse response) {
        return authService.login(loginRequestBody, response);
    }

    @RequestMapping("/logout")
    @NotNull
    public Result logout(HttpServletResponse response) {
        authService.removeToken(response);
        return Result.success();
    }

    @PostMapping("/register")
    public Result register(@RequestBody @NotNull RegisterRequestBody registerRequestBody) {
        return Result.success();
    }


}
