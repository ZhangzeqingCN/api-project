package com.example.apiproject.access;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "t_User")
public class User {
    @Id
    @Column(name = "Username", length = 50, unique = true)
    @NotBlank
    @Schema(example = testUserName, defaultValue = testUserName)
    String name;
    public static final String testUserName = "ZZQ";

    @Column(name = "Password", length = 50)
    @Schema(example = testPassword, defaultValue = testPassword)
    String password;
    public static final String testPassword = "123";

    @Builder.Default
    @Column(name = "Gender", length = 20)
    @NotBlank
    @Schema(example = testGender, defaultValue = testGender)
    com.example.apiproject.access.Gender gender = Gender.Unknown;

    public static final String testGender = "男";

    @Column(name = "Email", length = 50)
    @Email
    @Schema(example = testEmail, defaultValue = testEmail)
    String email;

    public static final String testEmail = "zzq123456@163.com";

    @Column(name = "Phone", length = 20)
    @Schema(example = testPhone, defaultValue = testPhone)
    String phone;
    public static final String testPhone = "12341234123";

    @Column(name = "Address", length = 100)
    @Schema(example = testAddress, defaultValue = testAddress)
    String address;
    public static final String testAddress = "北京交通大学";


}