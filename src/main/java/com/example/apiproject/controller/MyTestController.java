package com.example.apiproject.controller;


import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test")
public class MyTestController {
    @GetMapping
    @ResponseBody
    public String testMessage(@NotNull HttpServletRequest request) {
        var username = request.getAttribute("username");
        return String.format("Hello %s!", username);
    }

    @GetMapping("/login")
    public String login(@NotNull Model model) {
        model.addAttribute("loginMessage", "Welcome!");
        return "login";
    }
}
