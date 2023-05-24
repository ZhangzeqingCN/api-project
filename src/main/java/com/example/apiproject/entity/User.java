package com.example.apiproject.entity;

import jakarta.persistence.*;
import lombok.*;


@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "t_User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    String name;
    String password;
    Gender gender = Gender.Unknown;
    @Transient
    String token;
}
