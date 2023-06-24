package com.example.apiproject.controller;

import com.example.apiproject.domain.Result;
import com.example.apiproject.domain.req.auth.LoginRequestBody;
import com.example.apiproject.domain.req.auth.RegisterRequestBody;
import com.example.apiproject.service.AuthService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@Slf4j
@Tag(name = "AuthController", description = "用户管理相关接口控制器")
public class AuthController {

    private AuthService authService;

    @Autowired
    public void setAuthService(AuthService authService) {
        this.authService = authService;
    }

    /**
     * 用户登录。
     *
     * @param loginRequestBody 包含登录请求信息的对象。
     * @param response         HTTP响应对象，用于设置登录成功后的Token信息。
     * @return 登录结果的结果对象。
     */
    @PostMapping("/login")
    @NotNull
    @Operation(summary = "用户登录", description = "用户登录")
    public Result login(@RequestBody @NotNull @Valid LoginRequestBody loginRequestBody, HttpServletResponse response) {
        return authService.login(loginRequestBody, response);
    }

    /**
     * 用户注销登录。
     *
     * @param response HTTP响应对象，用于移除Token信息。
     * @return 注销结果的结果对象。
     */
    @GetMapping("/logout")
    @NotNull
    @Operation(summary = "用户注销登录", description = "用户注销登录")
    public Result logout(HttpServletResponse response) {
        authService.removeTokenCookie(response);
        return Result.success();
    }

    /**
     * 用户注册。
     *
     * @param registerRequestBody 包含注册请求信息的对象。
     * @return 注册结果的结果对象。
     */
    @PostMapping("/register")
    @Operation(summary = "用户注册", description = "用户注册")
    public Result register(@RequestBody @NotNull @Valid RegisterRequestBody registerRequestBody) {
        return authService.register(registerRequestBody);
    }
}
