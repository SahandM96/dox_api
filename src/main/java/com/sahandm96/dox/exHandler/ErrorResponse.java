package com.sahandm96.dox.exHandler;


import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ErrorResponse {
    private String message;
    private Integer code= -1;
    private List<String> data = new ArrayList<>();

    public ErrorResponse(String message) {
        this.message = message;
    }

    public ErrorResponse(String message, Integer code) {
        this.message = message;
        this.code = code;
    }
}
