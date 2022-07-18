package com.jjpeng.ssia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * @author JJPeng
 * @date 2022/7/10 14:46
 */
@Configuration
public class UserManagementConfig {

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        UserDetails john = User.withUsername("john")
                .password("12345")
                .authorities("ROLE_ADMIN")
                .build();
        UserDetails jane = User.withUsername("jane")
                .password("12345")
                .authorities("ROLE_MANAGER")
                .build();
        manager.createUser(john);
        manager.createUser(jane);
        return manager;
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
