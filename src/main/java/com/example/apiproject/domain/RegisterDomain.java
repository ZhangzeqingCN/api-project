package com.example.apiproject.domain;

import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class RegisterDomain {
    private String username;
    private String password1;
    private String password2;
    private String email;
    private String phone;
}
