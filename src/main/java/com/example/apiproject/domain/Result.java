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
@EqualsAndHashCode
public class Result {
    private boolean success;
    private int code;
    private String message;
    private Object data;
    public final List<Object> errors = new ArrayList<>();
}
