package com.jjpeng.ssia.config;

import com.jjpeng.ssia.filter.AuthenticationLoggingFilter;
import com.jjpeng.ssia.filter.StaticKeyAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

/**
 * @author JJPeng
 * @date 2022/7/10 19:48
 */
@Configuration
public class WebAuthorizationConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private StaticKeyAuthenticationFilter staticKeyAuthenticationFilter;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        //关闭CSRF 为了可以调用/a路径的post请求，不关闭的话会401
        http.csrf().disable();

        http.addFilterAfter(
                new AuthenticationLoggingFilter(),
                BasicAuthenticationFilter.class);

        http.authorizeRequests()
                .anyRequest().permitAll();
    }
}
