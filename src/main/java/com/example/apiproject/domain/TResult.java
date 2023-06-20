package com.example.apiproject.domain;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class TResult<T> {
    private boolean success;
    private String message;
    private T data;
    public final List<Object> errors = new ArrayList<>();

    public static <U> com.example.delombok.domain.TResult<U> success() {
        return com.example.delombok.domain.TResult.<U>builder().success(true).build();
    }

    public static <U> com.example.delombok.domain.TResult<U> success(U data) {
        return com.example.delombok.domain.TResult.<U>builder().success(true).data(data).build();
    }

    public static <U> com.example.delombok.domain.TResult<U> error(String message) {
        return com.example.delombok.domain.TResult.<U>builder().success(false).message(message).build();
    }

    public com.example.delombok.domain.TResult<T> addErrors(Object error) {
        errors.add(error);
        return this;
    }
}
