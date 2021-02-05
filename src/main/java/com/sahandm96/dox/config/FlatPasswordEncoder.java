package com.sahandm96.dox.config;

import org.springframework.security.crypto.password.PasswordEncoder;

public class FlatPasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();// man too charcharkh password ro bedoone inke encode konam zakhire mikonam
    }
// ba bcrypt moshkel mikhore spring engar na
    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.toString().equals(encodedPassword);
    }
}
