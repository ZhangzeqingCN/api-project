package com.example.apiproject.interceptor;


import com.example.apiproject.utils.MyJwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    private MyJwtUtil jwtUtil;

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
    }

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        var cookies = request.getCookies();
        Optional<Cookie> optionalCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("token")).findAny();
        String token = optionalCookie.map(Cookie::getValue).orElse("");

        log.info(String.format("old token: %s", token));
        var optionalUsername = jwtUtil.decodeToken(token);

        if (optionalUsername.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            log.info("No username in token");
            return false;
        }

        var username = optionalUsername.get();
        request.setAttribute("username", username);
        token = jwtUtil.createToken(username);
        log.info(String.format("new token: %s", token));
        var cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setMaxAge(30000000);
        response.addCookie(cookie);

        return true;
    }

    @Override
    public void afterCompletion(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, Exception ex) throws Exception {

    }

    @Autowired
    public void setJwtUtil(MyJwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }
}


