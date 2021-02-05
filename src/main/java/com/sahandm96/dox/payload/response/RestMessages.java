package com.sahandm96.dox.payload.response;

import lombok.Data;

@Data
public class RestMessages {
    private String Message;
    private String Code;
    private Object Data;

    public RestMessages() {
    }

    public RestMessages(String message) {
        this.Message = message;
    }

    public RestMessages(Object data) {
        this.Data = data;
    }

    public RestMessages(String message, String code, Object data) {
        Message = message;
        Code = code;
        Data = data;
    }

    public RestMessages SuccessMessage(String message, Object data) {
        RestMessages restMessages = new RestMessages();
        restMessages.setCode("200");
        restMessages.setData(data);
        restMessages.setMessage(message);
        return restMessages;
    }

    public RestMessages SuccessMessage(String message, Object data, String code) {
        RestMessages restMessages = new RestMessages();
        restMessages.setCode(code);
        restMessages.setData(data);
        restMessages.setMessage(message);
        return restMessages;
    }

    public RestMessages NotFoundMessage(String message) {
        RestMessages restMessages = new RestMessages();
        restMessages.setCode("400");
        restMessages.setData(null);
        restMessages.setMessage(message);
        return restMessages;
    }

    public RestMessages NotFoundMessage(String message, String code) {
        RestMessages restMessages = new RestMessages();
        restMessages.setCode(code);
        restMessages.setData(null);
        restMessages.setMessage(message);
        return restMessages;
    }

    public RestMessages NotFoundMessage(String message, String code, Object object) {
        RestMessages restMessages = new RestMessages();
        restMessages.setCode(code);
        restMessages.setData(object);
        restMessages.setMessage(message);
        return restMessages;
    }
}
