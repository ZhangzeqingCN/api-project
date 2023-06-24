package com.example.apiproject.controller;


import com.example.apiproject.domain.Result;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import org.jetbrains.annotations.NotNull;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
@Tag(name = "MyTestController", description = "测试接口相关接口控制器")
public class MyTestController {
    @GetMapping
    @Operation(summary = "测试信息", description = "测试信息")
    public String testMessage(@NotNull HttpServletRequest request) {
        var username = request.getAttribute("username");
        return String.format("Hello %s!", username);
    }

    @GetMapping("/error")
    @Operation(summary = "测试报错", description = "测试报错")
    public Result error() {
        throw new IllegalStateException("Error");
    }
}
