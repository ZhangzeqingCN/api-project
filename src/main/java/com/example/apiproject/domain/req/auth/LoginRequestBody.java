package com.example.apiproject.domain.req.auth;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString
public class LoginRequestBody {
    @NonNull
    private String username;
    @NonNull
    private String password;
}
