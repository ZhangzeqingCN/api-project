package com.example.apiproject.service;

import com.example.apiproject.auth.CookieTokenGetter;
import com.example.apiproject.auth.HeadersTokenGetter;
import com.example.apiproject.domain.Result;
import com.example.apiproject.domain.auth.LoginRequestBody;
import com.example.apiproject.domain.auth.RegisterRequestBody;
import com.example.apiproject.entity.User;
import com.example.apiproject.repository.UserRepository;
import com.example.apiproject.auth.TokenGetter;
import com.example.apiproject.utils.MyJwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @apiNote 用于用户权限的识别
 */
@Service
@Slf4j
public class AuthService {
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

    @NotNull
    public Result login(@NotNull LoginRequestBody loginRequestBody, @NotNull HttpServletResponse response) {
        if (!userRepository.existsByNameAndPassword(loginRequestBody.getUsername(), loginRequestBody.getPassword())) {
            String message = String.format("wrong username %s or password %s", loginRequestBody.getUsername(), loginRequestBody.getPassword());
            log.info(message);
            return Result.error(message).addErrors(message).addErrors(loginRequestBody);
        }

        log.info(String.format("login username %s with password %s", loginRequestBody.getUsername(), loginRequestBody.getPassword()));

        setResponseToken(loginRequestBody.getUsername(), response);

        return Result.success();
    }

    @NotNull
    public Result register(@NotNull RegisterRequestBody registerRequestBody) {

        if (userRepository.existsByName(registerRequestBody.getUsername())) {
            String message = String.format("username %s already exists", registerRequestBody.getUsername());
            log.info(message);
            return Result.error(message).addErrors(registerRequestBody.getUsername());
        }

        if (!Objects.equals(registerRequestBody.getPassword1(), registerRequestBody.getPassword2())) {
            String message = "inconsistent two passwords";
            log.info(message);
            return Result.error(message);
        }

        userRepository.save(User.builder()
                .name(registerRequestBody.getUsername())
                .password(registerRequestBody.getPassword1())
                .gender(registerRequestBody.getGender())
                .build());

        return Result.success();
    }

    /**
     * 设置token
     *
     * @param username 用户名
     * @param response 当次的响应
     */
    public void setResponseToken(String username, @NotNull HttpServletResponse response) {
        String token = jwtUtil.createToken(username);
        log.info(String.format("new token for %s: %s", username, token));
        var cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setMaxAge(30000000);
        response.addCookie(cookie);
        response.addHeader("token", token);
    }

    /**
     * 清除token
     *
     * @param response 当次的响应
     */
    public void removeToken(@NotNull HttpServletResponse response) {
        var cookie = new Cookie("token", "");
        cookie.setPath("/");
        cookie.setMaxAge(30000000);
        response.addCookie(cookie);
    }

    List<TokenGetter> tokenGetters = Arrays.asList(
            new CookieTokenGetter(),
            new HeadersTokenGetter()
    );

    // @Autowired
    public void setGetTokens(List<TokenGetter> tokenGetters) {
        this.tokenGetters = tokenGetters;
    }

    /**
     * 检查token的有效性并更新token
     *
     * @param request  当次的请求
     * @param response 当次的响应
     * @return 结果
     */
    @NotNull
    public Result validateAndUpdateToken(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {

        Optional<String> token = Optional.empty();

        for (TokenGetter tokenGetter : tokenGetters) {
            if (token.isEmpty()) {
                token = tokenGetter.getToken(request);
            } else {
                break;
            }
        }

        if (token.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            var message = String.format("%s: No token", request.getRequestURL());
            log.info(message);
            return Result.error(message);
        }

        Optional<String> optionalUsername = jwtUtil.decodeToken(token.get());

        if (optionalUsername.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            var message = String.format("%s: No username in token", request.getRequestURL());
            log.info(message);
            return Result.error(message);
        }

        var username = optionalUsername.get();

        request.setAttribute("username", username);

        setResponseToken(username, response);

        return Result.success();
    }
}
