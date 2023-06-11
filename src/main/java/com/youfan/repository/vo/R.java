package com.youfan.repository.vo;

import lombok.Data;

@Data
public class R<T> {

    private Integer code;
    private String message;
    private T data;

    private R(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> R<T> ok(T data) {
        return new R<>(20000, "OK", data);
    }

    public static <T> R<T> ok() {
        return ok(null);
    }

    public static <T> R<T> fail(String message) {
        return new R<>(0, message, null);
    }

    public static <T> R<T> fail() {
        return fail("fail");
    }


}
