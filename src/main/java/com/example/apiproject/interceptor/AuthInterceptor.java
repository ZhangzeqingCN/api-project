package com.example.apiproject.interceptor;


import com.example.apiproject.utils.MyJwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;
import java.util.Random;

@Slf4j
@Component
public class AuthInterceptor implements HandlerInterceptor {

    private MyJwtUtil jwtUtil;

    Random random = new Random();

    @Override
    public void postHandle(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler, ModelAndView modelAndView) throws Exception {
        log.info(String.format("postHandle token: %s", request.getHeader("token")));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull Object handler) throws Exception {
        log.info(String.format("preHandle token: %s", request.getHeader("token")));
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


