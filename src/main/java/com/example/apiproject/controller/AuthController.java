package com.example.apiproject.controller;

import com.example.delombok.domain.Result;
import com.example.delombok.domain.req.auth.LoginRequestBody;
import com.example.delombok.domain.req.auth.RegisterRequestBody;
import com.example.delombok.service.AuthService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
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

    /**
     * 用户登录。
     *
     * @param loginRequestBody 包含登录请求信息的对象。
     * @param response         HTTP响应对象，用于设置登录成功后的Token信息。
     * @return 登录结果的结果对象。
     */
    @PostMapping("/login")
    @NotNull
    public Result login(@RequestBody @NotNull @Valid LoginRequestBody loginRequestBody, HttpServletResponse response) {
        return authService.login(loginRequestBody, response);
    }

    /**
     * 用户注销登录。
     *
     * @param response HTTP响应对象，用于移除Token信息。
     * @return 注销结果的结果对象。
     */
    @RequestMapping("/logout")
    @NotNull
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
    public Result register(@RequestBody @NotNull @Valid RegisterRequestBody registerRequestBody) {
        return authService.register(registerRequestBody);
    }
}
