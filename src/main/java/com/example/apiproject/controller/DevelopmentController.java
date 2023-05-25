package com.example.apiproject.controller;

import com.example.apiproject.domain.auth.LoginDomain;
import com.example.apiproject.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/dev")
@Slf4j
public class DevelopmentController {

    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/login")
    public String login(@NotNull Model model) {
        model.addAttribute("loginMessage", "Welcome!");
        return "login";
    }

    @PostMapping("/login")
    public String login(@NotNull Model model, @RequestParam String username, @RequestParam String password, HttpServletResponse response) {
        var result = authService.login(LoginDomain.builder()
                .username(username)
                .password(password)
                .build(), response);
        model.addAttribute("loginMessage", result.isSuccess() ? "Login successfully!" : result.getMessage());
        return "login";
    }
}
