// Generated by delombok at Tue Jun 20 17:11:51 CST 2023
package com.example.delombok.domain;

import java.util.ArrayList;
import java.util.List;

public class Result {
    private boolean success;
    private String message;
    private Object data;
    public final List<Object> errors = new ArrayList<>();

    public static Result success() {
        return Result.builder().success(true).build();
    }

    public static Result success(Object data) {
        return Result.builder().success(true).data(data).build();
    }

    public static Result error(String message) {
        return Result.builder().success(false).message(message).build();
    }

    public Result addErrors(Object error) {
        errors.add(error);
        return this;
    }


    @java.lang.SuppressWarnings("all")
    public static class ResultBuilder {
        @java.lang.SuppressWarnings("all")
        private boolean success;
        @java.lang.SuppressWarnings("all")
        private String message;
        @java.lang.SuppressWarnings("all")
        private Object data;

        @java.lang.SuppressWarnings("all")
        ResultBuilder() {
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public Result.ResultBuilder success(final boolean success) {
            this.success = success;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public Result.ResultBuilder message(final String message) {
            this.message = message;
            return this;
        }

        /**
         * @return {@code this}.
         */
        @java.lang.SuppressWarnings("all")
        public Result.ResultBuilder data(final Object data) {
            this.data = data;
            return this;
        }

        @java.lang.SuppressWarnings("all")
        public Result build() {
            return new Result(this.success, this.message, this.data);
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("all")
        public java.lang.String toString() {
            return "Result.ResultBuilder(success=" + this.success + ", message=" + this.message + ", data=" + this.data + ")";
        }
    }

    @java.lang.SuppressWarnings("all")
    public static Result.ResultBuilder builder() {
        return new Result.ResultBuilder();
    }

    @java.lang.SuppressWarnings("all")
    public void setSuccess(final boolean success) {
        this.success = success;
    }

    @java.lang.SuppressWarnings("all")
    public void setMessage(final String message) {
        this.message = message;
    }

    @java.lang.SuppressWarnings("all")
    public void setData(final Object data) {
        this.data = data;
    }

    @java.lang.SuppressWarnings("all")
    public boolean isSuccess() {
        return this.success;
    }

    @java.lang.SuppressWarnings("all")
    public String getMessage() {
        return this.message;
    }

    @java.lang.SuppressWarnings("all")
    public Object getData() {
        return this.data;
    }

    @java.lang.SuppressWarnings("all")
    public List<Object> getErrors() {
        return this.errors;
    }

    @java.lang.SuppressWarnings("all")
    public Result(final boolean success, final String message, final Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    @java.lang.SuppressWarnings("all")
    public Result() {
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("all")
    public java.lang.String toString() {
        return "Result(success=" + this.isSuccess() + ", message=" + this.getMessage() + ", data=" + this.getData() + ", errors=" + this.getErrors() + ")";
    }
}
