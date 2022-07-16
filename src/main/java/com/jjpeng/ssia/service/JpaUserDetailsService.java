package com.jjpeng.ssia.service;

import com.jjpeng.ssia.model.CustomUserDetails;
import com.jjpeng.ssia.model.User;
import com.jjpeng.ssia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

/**
 * @author JJPeng
 * @date 2022/7/16 22:06
 */
@Service
public class JpaUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Supplier<UsernameNotFoundException> exception =
                () -> new UsernameNotFoundException("Problem during authentication!");

        User user = userRepository.findUserByUsername(username).orElseThrow(exception);
        return new CustomUserDetails(user);
    }
}
