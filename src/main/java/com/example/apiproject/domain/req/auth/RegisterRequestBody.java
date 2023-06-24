package com.example.apiproject.domain.req.auth;

import com.example.apiproject.access.Gender;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.*;

import static com.example.apiproject.access.User.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor(force = true)
@ToString
public class RegisterRequestBody {
    @NonNull
    @Schema(example = testUserName, defaultValue = testUserName, description = "用户名")
    private String username;
    @NonNull
    @Schema(example = testPassword, defaultValue = testPassword, description = "密码")
    private String password1;
    @NonNull
    @Schema(example = testPassword, defaultValue = testPassword, description = "重复密码")
    private String password2;
    @Email
    @Schema(example = testEmail, defaultValue = testEmail, description = "邮箱")
    private String email;
    @Schema(example = testPhone, defaultValue = testPhone, description = "手机号")
    private String phone;
    @Builder.Default
    @Schema(example = testGender, defaultValue = testGender, description = "性别")
    private Gender gender = Gender.Unknown;
}
