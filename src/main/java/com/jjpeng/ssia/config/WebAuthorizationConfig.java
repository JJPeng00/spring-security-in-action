package com.jjpeng.ssia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author JJPeng
 * @date 2022/7/10 19:48
 */
@Configuration
//允许pre/postauthorization
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebAuthorizationConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
    }
}
