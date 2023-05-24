package com.example.apiproject.controller;


import com.example.apiproject.domain.auth.LoginDomain;
import com.example.apiproject.domain.Result;
import com.example.apiproject.domain.auth.RegisterDomain;
import com.example.apiproject.entity.User;
import com.example.apiproject.service.AuthService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.web.bind.annotation.*;

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
    public Result login(@RequestBody @NotNull LoginDomain loginDomain, @NotNull HttpServletResponse response) {
        return authService.login(loginDomain, response);
    }

    @PostMapping("/register")
    @NotNull
    public Result register(@RequestBody @NotNull RegisterDomain registerDomain) {
        return authService.register(registerDomain);
    }

    @GetMapping("/test-token")
    public Result testToken(@NotNull HttpServletResponse response) {
        var token = authService.createToken("user");
        var user = User.builder()
                .name("user")
                .token(token)
                .build();
        var cookie = new Cookie("token", token);
        response.addCookie(cookie);
        return Result.builder()
                .success(true)
                .data(user)
                .build();
    }

}
