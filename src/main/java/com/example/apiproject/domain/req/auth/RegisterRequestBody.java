package com.example.apiproject.domain.req.auth;

import com.example.apiproject.access.Gender;
import jakarta.validation.constraints.Email;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString
public class RegisterRequestBody {
    @NonNull
    private String username;
    @NonNull
    private String password1;
    @NonNull
    private String password2;
    @Email
    private String email;
    private String phone;
    @Builder.Default
    private Gender gender = Gender.Unknown;
}
