package com.example.apiproject.controller;


import com.example.apiproject.domain.Result;
import com.example.apiproject.domain.auth.LoginDomain;
import com.example.apiproject.domain.auth.RegisterDomain;
import com.example.apiproject.repository.UserRepository;
import com.example.apiproject.utils.MyJwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private UserRepository userRepository;

    private MyJwtUtil jwtUtil;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setJwtUtil(MyJwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    @NotNull
    public Result login(@RequestBody @NotNull LoginDomain loginDomain, @NotNull HttpServletResponse response) {

        if (!userRepository.existsByNameAndPassword(loginDomain.getUsername(), loginDomain.getPassword())) {
            return Result.error("wrong username or password").addErrors(loginDomain.getUsername()).addErrors(loginDomain.getPassword());
        }

        String token = jwtUtil.createToken(loginDomain.getUsername());
        var cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setMaxAge(30000000);
        response.addCookie(cookie);

        return Result.success();
    }

    @RequestMapping("/logout")
    @NotNull
    public Result logout(@NotNull HttpServletResponse response) {
        var cookie = new Cookie("token", "");
        cookie.setPath("/");
        cookie.setMaxAge(30000000);
        response.addCookie(cookie);
        return Result.success();
    }

    @PostMapping("/register")
    public Result register(@RequestBody @NotNull RegisterDomain registerDomain) {
        return Result.success();
    }


}
