package com.example.apiproject.service;

import com.example.apiproject.domain.Result;
import com.example.apiproject.domain.req.auth.LoginRequestBody;
import com.example.apiproject.domain.req.auth.RegisterRequestBody;
import com.example.apiproject.access.User;
import com.example.apiproject.repository.UserRepository;
import com.example.apiproject.utils.MyJwtUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

    /**
     *
     * @param loginRequestBody login request body
     * @param response login request response
     * @return login result
     */
    @NotNull
    public Result login(@NotNull LoginRequestBody loginRequestBody, @NotNull HttpServletResponse response) {
        if (!userRepository.existsByNameAndPassword(loginRequestBody.getUsername(), loginRequestBody.getPassword())) {
            // 登录失败 wrong username %s or password %s
            String message = String.format("wrong username %s or password %s", loginRequestBody.getUsername(), loginRequestBody.getPassword());
            log.info(message);
            return Result.error(message).addErrors(message).addErrors(loginRequestBody);
        }

        log.info(String.format("login username %s with password %s", loginRequestBody.getUsername(), loginRequestBody.getPassword()));

        setTokenCookie(loginRequestBody.getUsername(), response);

        return Result.success();
    }

    /**
     *
     * @param registerRequestBody register request body
     * @return Result
     */
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
    public void setTokenCookie(String username, @NotNull HttpServletResponse response) {
        String token = jwtUtil.createToken(username);
        log.info(String.format("new token for %s: %s", username, token));
        var cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setMaxAge(30000000);
        response.addCookie(cookie);
    }

    /**
     * 清除token
     *
     * @param response 当次的响应
     */
    public void removeTokenCookie(@NotNull HttpServletResponse response) {
        var cookie = new Cookie("token", "");
        cookie.setPath("/");
        cookie.setMaxAge(30000000);
        response.addCookie(cookie);
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
        var cookies = request.getCookies();

        if (cookies == null || cookies.length == 0) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            var message = String.format("%s: No token in cookie", request.getRequestURL());
            log.info(message);
            return Result.error(message);
        }

        Optional<Cookie> optionalCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("token")).findAny();
        String token = optionalCookie.map(Cookie::getValue).orElse("");

        log.info(String.format("old token: %s", token));
        var optionalUsername = jwtUtil.decodeToken(token);

        if (optionalUsername.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            var message = String.format("%s: No username in token", request.getRequestURL());
            log.info(message);
            return Result.error(message);
        }

        var username = optionalUsername.get();
        request.setAttribute("username", username);
        setTokenCookie(username, response);

        return Result.success();
    }
}
