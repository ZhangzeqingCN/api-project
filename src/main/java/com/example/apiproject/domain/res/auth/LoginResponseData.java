package com.example.apiproject.domain.res.auth;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString
public class LoginResponseData {
    String accessToken;
    String refreshToken;
}
