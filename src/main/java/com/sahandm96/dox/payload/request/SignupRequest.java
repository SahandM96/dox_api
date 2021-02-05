package com.sahandm96.dox.payload.request;

import lombok.Data;

import java.util.List;

@Data
public class SignupRequest {
    private String username;

    private String email;

    private List<String> roles;

    private String password;
}
