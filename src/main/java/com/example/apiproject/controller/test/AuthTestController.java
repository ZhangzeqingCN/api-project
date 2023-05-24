package com.example.apiproject.controller.test;

import com.example.apiproject.domain.Result;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test0")
public class AuthTestController {
    @GetMapping
    @NotNull
    public Result testMessage() {
        return Result.success("Test message from " + getClass().getName());
    }
}
