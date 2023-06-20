package com.example.apiproject.service;

import com.example.delombok.domain.Result;
import com.example.delombok.domain.req.auth.LoginRequestBody;
import com.example.delombok.domain.req.auth.RegisterRequestBody;
import com.example.delombok.access.User;
import com.example.delombok.repository.UserRepository;
import com.example.delombok.utils.MyJwtUtil;
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
 * Service class for user authentication and authorization.
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
     * Authenticates a user based on the login credentials.
     *
     * @param loginRequestBody The login request body containing the username and password.
     * @param response         The HTTP response object.
     * @return The authentication result.
     */
    @NotNull
    public Result login(@NotNull LoginRequestBody loginRequestBody, @NotNull HttpServletResponse response) {
        if (!userRepository.existsByNameAndPassword(loginRequestBody.getUsername(), loginRequestBody.getPassword())) {
            String message = String.format("Wrong username %s or password %s", loginRequestBody.getUsername(), loginRequestBody.getPassword());
            log.info(message);
            return Result.error(message).addErrors(message).addErrors(loginRequestBody);
        }

        log.info(String.format("User logged in: username %s", loginRequestBody.getUsername()));

        setTokenCookie(loginRequestBody.getUsername(), response);

        return Result.success();
    }

    /**
     * Registers a new user.
     *
     * @param registerRequestBody The register request body containing the username, password, and gender.
     * @return The registration result.
     */
    @NotNull
    public Result register(@NotNull RegisterRequestBody registerRequestBody) {
        if (userRepository.existsByName(registerRequestBody.getUsername())) {
            String message = String.format("Username %s already exists", registerRequestBody.getUsername());
            log.info(message);
            return Result.error(message).addErrors(registerRequestBody.getUsername());
        }

        if (!Objects.equals(registerRequestBody.getPassword1(), registerRequestBody.getPassword2())) {
            String message = "The two passwords provided do not match";
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
     * Sets the token as a cookie in the HTTP response.
     *
     * @param username The username.
     * @param response The HTTP response object.
     */
    public void setTokenCookie(String username, @NotNull HttpServletResponse response) {
        String token = jwtUtil.createToken(username);
        log.info(String.format("New token for user %s: %s", username, token));
        var cookie = new Cookie("token", token);
        cookie.setPath("/");
        cookie.setMaxAge(30000000);
        response.addCookie(cookie);
    }

    /**
     * Removes the token cookie from the HTTP response.
     *
     * @param response The HTTP response object.
     */
    public void removeTokenCookie(@NotNull HttpServletResponse response) {
        var cookie = new Cookie("token", "");
        cookie.setPath("/");
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    /**
     * Validates the token in the HTTP request and updates the token.
     *
     * @param request  The HTTP request object.
     * @param response The HTTP response object.
     * @return The validation and update result.
     */
    @NotNull
    public Result validateAndUpdateToken(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) {
        var cookies = request.getCookies();

        if (cookies == null || cookies.length == 0) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            var message = String.format("%s: No token in the cookie", request.getRequestURL());
            log.info(message);
            return Result.error(message);
        }

        Optional<Cookie> optionalCookie = Arrays.stream(cookies).filter(cookie -> cookie.getName().equals("token")).findAny();
        String token = optionalCookie.map(Cookie::getValue).orElse("");

        log.info(String.format("Old token: %s", token));
        var optionalUsername = jwtUtil.decodeToken(token);

        if (optionalUsername.isEmpty()) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            var message = String.format("%s: No username in the token", request.getRequestURL());
            log.info(message);
            return Result.error(message);
        }

        var username = optionalUsername.get();
        request.setAttribute("username", username);
        setTokenCookie(username, response);

        return Result.success();
    }
}
