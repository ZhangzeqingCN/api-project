// Generated by delombok at Tue Jun 20 17:11:51 CST 2023
package com.example.delombok.access;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "t_User")
public class User {
    @Id
    @Column(name = "Username", length = 50, unique = true)
    @NotBlank
    String name;
    @Column(name = "Password", length = 50)
    String password;
    @Column(name = "Gender", length = 20)
    @NotBlank
    Gender gender;
    @Column(name = "Email", length = 50)
    @Email
    String email;
    @Column(name = "Phone", length = 20)
    String phone;
    @Column(name = "Address", length = 100)
    String address;

    @java.lang.SuppressWarnings("all")
    private static Gender $default$gender() {
        return Gender.Unknown;
    }


    @java.lang.SuppressWarnings("all")
    public static class UserBuilder {
        @java.lang.SuppressWarnings("all")
        private String name;
        @java.lang.SuppressWarnings("all")
        private String password;
        @java.lang.SuppressWarnings("all")
        private boolean gender$set;
        @java.lang.SuppressWarnings("all")
        private Gender gender$value;
        @java.lang.SuppressWarnings("all")
        private String email;
        @java.lang.SuppressWarnings("all")
        private String phone;
        @java.lang.SuppressWarnings("all")
        private String address;

        @java.lang.SuppressWarnings("all")
        UserBuilder() {
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public User.UserBuilder name(final String name) {
            this.name = name;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public User.UserBuilder password(final String password) {
            this.password = password;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public User.UserBuilder gender(final Gender gender) {
            this.gender$value = gender;
            gender$set = true;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public User.UserBuilder email(final String email) {
            this.email = email;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public User.UserBuilder phone(final String phone) {
            this.phone = phone;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public User.UserBuilder address(final String address) {
            this.address = address;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public User build() {
            Gender gender$value = this.gender$value;
            if (!this.gender$set) gender$value = User.$default$gender();
            return new User(this.name, this.password, gender$value, this.email, this.phone, this.address);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public java.lang.String toString() {
            return "User.UserBuilder(name=" + this.name + ", password=" + this.password + ", gender$value=" + this.gender$value + ", email=" + this.email + ", phone=" + this.phone + ", address=" + this.address + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    public static User.UserBuilder builder() {
        return new User.UserBuilder();
    }

    @java.lang.SuppressWarnings("all")
    public void setName(final String name) {
        this.name = name;
    }

    @java.lang.SuppressWarnings("all")
    public void setPassword(final String password) {
        this.password = password;
    }

    @java.lang.SuppressWarnings("all")
    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    @java.lang.SuppressWarnings("all")
    public void setEmail(final String email) {
        this.email = email;
    }

    @java.lang.SuppressWarnings("all")
    public void setPhone(final String phone) {
        this.phone = phone;
    }

    @java.lang.SuppressWarnings("all")
    public void setAddress(final String address) {
        this.address = address;
    }

    @java.lang.SuppressWarnings("all")
    public String getName() {
        return this.name;
    }

    @java.lang.SuppressWarnings("all")
    public String getPassword() {
        return this.password;
    }

    @java.lang.SuppressWarnings("all")
    public Gender getGender() {
        return this.gender;
    }

    @java.lang.SuppressWarnings("all")
    public String getEmail() {
        return this.email;
    }

    @java.lang.SuppressWarnings("all")
    public String getPhone() {
        return this.phone;
    }

    @java.lang.SuppressWarnings("all")
    public String getAddress() {
        return this.address;
    }

    @java.lang.SuppressWarnings("all")
    public User(final String name, final String password, final Gender gender, final String email, final String phone, final String address) {
        this.name = name;
        this.password = password;
        this.gender = gender;
        this.email = email;
        this.phone = phone;
        this.address = address;
    }

    @java.lang.SuppressWarnings("all")
    public User() {
        this.gender = User.$default$gender();
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "User(name=" + this.getName() + ", password=" + this.getPassword() + ", gender=" + this.getGender() + ", email=" + this.getEmail() + ", phone=" + this.getPhone() + ", address=" + this.getAddress() + ")";
    }
}
