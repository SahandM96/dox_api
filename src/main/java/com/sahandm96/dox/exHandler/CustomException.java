package com.sahandm96.dox.exHandler;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class CustomException extends RuntimeException {

    private String code;
    private Object[] args;

    public CustomException() {
    }

    public CustomException(String code) {
        this.code = code;
    }

    public CustomException(String code, Object... args) {
        super("ADVISOR_VALIDATION_EXCEPTION");
        this.code = code;
        this.args = args;
    }

}
