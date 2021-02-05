package com.sahandm96.dox.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Data
@Document
public class User implements Serializable, UserDetails {
    private static final long serialVersionUID = 1L;
    @Id
    private String id;
    @Indexed(unique = true, direction = IndexDirection.DESCENDING, dropDups = true)

    private String username;
    //    @JsonIgnore
    private String password;

    private String firstName;
    private String lastName;

    private String BDay;

    private String imageUrl;

    private String email;
    private String cellPhoneNumber;

    private String[] links;

//    private String twitch;
//    private String youtube;
//    private String instagram;
//    private String twitterName;
//    private String linkedinName;



    @JsonIgnore
    private Boolean active = true;
    @JsonIgnore
    private String moaref;
    @JsonIgnore
    private Date createDate = new Date();
    @JsonIgnore
    private Date updateDate = new Date();
    @JsonIgnore
    private Date lastLogin = new Date();

    @JsonIgnore
    private List<Role> roles;


    public User() {
    }

    public User(String username, String password, List<Role> roles, Boolean active) {
        this.username = username;
        this.password = password;
        this.roles = roles;
        this.active = active;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
