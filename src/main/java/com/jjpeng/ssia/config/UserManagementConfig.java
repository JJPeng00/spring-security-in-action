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
        UserDetails natalie = User.withUsername("natalie")
                .password("12345")
                .roles("admin")
                .build();
        UserDetails emma = User.withUsername("emma")
                .password("12345")
                .roles("manager")
                .build();
        manager.createUser(natalie);
        manager.createUser(emma);
        return manager;
    }

    @Bean
    public PasswordEncoder bCryptPasswordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
