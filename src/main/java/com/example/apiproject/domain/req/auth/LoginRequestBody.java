package com.example.apiproject.domain.req.auth;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString
public class LoginRequestBody {
    @NonNull
    @Schema(example = "ZZQ1", defaultValue = "ZZQ2", description = "用户名")
    String username;
    @NonNull
    String password;
}
