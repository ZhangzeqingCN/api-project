package com.example.apiproject.service;

import com.example.apiproject.domain.LoginDomain;
import com.example.apiproject.domain.Result;
import com.example.apiproject.repository.UserRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @NotNull
    public Result login(@NotNull LoginDomain loginDomain) {
        userRepository.existsByName(loginDomain.getUsername());
        return Result.builder().build();
    }
}
