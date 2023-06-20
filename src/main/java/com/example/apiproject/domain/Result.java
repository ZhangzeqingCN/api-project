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
public class Result {
    private boolean success;
    private String message;
    private Object data;
    public final List<Object> errors = new ArrayList<>();

    public static com.example.delombok.domain.Result success() {
        return com.example.delombok.domain.Result.builder().success(true).build();
    }

    public static com.example.delombok.domain.Result success(Object data) {
        return com.example.delombok.domain.Result.builder().success(true).data(data).build();
    }

    public static com.example.delombok.domain.Result error(String message) {
        return com.example.delombok.domain.Result.builder().success(false).message(message).build();
    }

    public com.example.delombok.domain.Result addErrors(Object error) {
        errors.add(error);
        return this;
    }
}
