package com.example.apiproject.service;

import com.example.apiproject.domain.auth.LoginDomain;
import com.example.apiproject.domain.Result;
import com.example.apiproject.domain.auth.RegisterDomain;
import com.example.apiproject.repository.UserRepository;
import com.example.apiproject.utils.MyJwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserRepository userRepository;
    private MyJwtUtil jwtUtil;

    @Autowired
    public void setJwtUtil(MyJwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @NotNull
    public Result login(@NotNull LoginDomain loginDomain, @NotNull HttpServletResponse response) {
        userRepository.existsByName(loginDomain.getUsername());
        return Result.builder().build();
    }

    @NotNull
    public Result register(@NotNull RegisterDomain registerDomain) {
        return Result.builder().build();
    }

    @NotNull
    public String createToken(String username) {
        return jwtUtil.createToken(username);
    }
}
