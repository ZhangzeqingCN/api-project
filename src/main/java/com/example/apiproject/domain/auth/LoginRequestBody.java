package com.example.apiproject.domain.auth;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class LoginRequestBody {
    private String username;
    private String password;
}
