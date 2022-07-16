package com.jjpeng.ssia.config;

import com.jjpeng.ssia.service.AuthenticationProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author JJPeng
 * @date 2022/7/10 19:48
 */
@Configuration
public class WebAuthorizationConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProviderService authenticationProvider;

    //认证是由AuthenticationManager调用AuthenticationProvider的方法完成的，所以当我们需要指定provider时，
    //应进行如下配置（使用参数为AuthenticationManagerBuilder的configure方法
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider);
    }
}
