package com.jjpeng.ssia.security;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author JJPeng
 * @date 2022/7/10 16:38
 */
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String userName = authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        if ("john".equals(userName) && "12345".equals(password)) {
            return new UsernamePasswordAuthenticationToken(userName, password, Arrays.asList());
        } else {
            throw new AuthenticationCredentialsNotFoundException("Error!");
        }
    }

    @Override
    public boolean supports(Class<?> authenticationType) {
        //暂不需在意这里为什么这么写，后续将详细讨论
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authenticationType);
    }
}
