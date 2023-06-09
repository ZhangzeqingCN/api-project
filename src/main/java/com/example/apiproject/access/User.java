package com.example.apiproject.access;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


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
    String name;
    String password;
    @Builder.Default
    Gender gender = Gender.Unknown;
    String email;
    String phone;
    String address;
}
