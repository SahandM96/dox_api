package com.sahandm96.dox.domain.dto;

import com.sahandm96.dox.domain.User;
import lombok.Data;

import java.io.Serializable;

@Data
public class UserResponseDTO implements Serializable {
    private static final long serialVersionUID = -1969732265831514760L;
    String id;
    String username;
    String email;
    boolean active;

    public UserResponseDTO(User user) {
        this.id = user.getId();
        this.active = user.getActive();
        this.email = user.getEmail();
        this.username = user.getUsername();
    }
}
