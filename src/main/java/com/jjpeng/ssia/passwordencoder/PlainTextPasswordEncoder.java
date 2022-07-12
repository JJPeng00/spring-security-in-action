package com.jjpeng.ssia.passwordencoder;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author JJPeng
 * @date 2022/7/12 21:43
 */
public class PlainTextPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return rawPassword.toString();
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return rawPassword.equals(encodedPassword);
    }
}
