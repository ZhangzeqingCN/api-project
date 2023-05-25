package com.example.apiproject.controller;

import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/dev")
public class DevelopmentController {
    @GetMapping("/login")
    public String login(@NotNull Model model) {
        model.addAttribute("loginMessage", "Welcome!");
        return "login";
    }
}
