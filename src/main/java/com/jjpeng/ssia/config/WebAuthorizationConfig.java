package com.jjpeng.ssia.config;

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
        //注释掉httpBasic是为了BasicAuthenticationFilter的实例不会被添加到过滤链中
//        http.httpBasic();
        //关闭CSRF 为了可以调用/a路径的post请求，不关闭的话会401
        http.csrf().disable();

        //将自定义的认证过滤器添加在原BasicAuthenticationFilter的位置
        // 因为http.httpBasic()被注释掉了，所以不会引入BasicAuthenticationFilter的实例，所以这并不等同于替换
        // 因为同一个位置允许通常存在多个过滤器，但是这些过滤器的过滤顺序是不确定的，所以应该避免在同一个位置添加多个过滤器
        http.addFilterAt(staticKeyAuthenticationFilter, BasicAuthenticationFilter.class);

        http.authorizeRequests()
                .anyRequest().permitAll();
    }
}
