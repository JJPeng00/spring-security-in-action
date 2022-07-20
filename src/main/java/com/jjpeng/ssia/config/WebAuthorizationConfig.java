package com.jjpeng.ssia.config;

import com.jjpeng.ssia.filter.CsrfTokenLoggerFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;

/**
 * @author JJPeng
 * @date 2022/7/10 19:48
 */
@Configuration
public class WebAuthorizationConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.formLogin()
                .defaultSuccessUrl("/main", true);

        http.addFilterAfter(new CsrfTokenLoggerFilter(), CsrfFilter.class);

        http.authorizeRequests()
                .anyRequest().authenticated();
    }
}
