package com.Test.praktek.component.message;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class ResultgetAll<T> {
    private int code;
    private boolean success;
    private String message;
    private T data;

    public ResultgetAll() {
        this.code = 200;
        this.success = true;
        this.message = "success";
        this.data = null;
    }
}
