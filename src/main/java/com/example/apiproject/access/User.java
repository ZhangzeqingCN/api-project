package com.example.apiproject.access;

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
    String name;

    @Column(name = "Password", length = 50)
    String password;

    @Builder.Default
    @Column(name = "Gender", length = 20)
    @NotBlank
    com.example.apiproject.access.Gender gender = Gender.Unknown;

    @Column(name = "Email", length = 50)
    @Email
    String email;

    @Column(name = "Phone", length = 20)
    String phone;

    @Column(name = "Address", length = 100)
    String address;


}