package com.example.apiproject.domain.req.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import static com.example.apiproject.access.User.testPassword;
import static com.example.apiproject.access.User.testUserName;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString
public class LoginRequestBody {
    @NonNull
    @Schema(example = testUserName, defaultValue = testUserName, description = "用户名")
    String username;
    @NonNull
    @Schema(example = testPassword, defaultValue = testPassword)
    String password;
}
