package com.jjpeng.ssia.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author JJPeng
 * @date 2022/7/10 19:48
 */
@Configuration
public class WebAuthorizationConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        //关闭CSRF 为了可以调用/a路径的post请求，不关闭的话会401
        http.csrf().disable();

        http.authorizeRequests()
                // get访问"/a"路径的请求需要进行用户认证
                .mvcMatchers(HttpMethod.GET, "/a").authenticated()
                // post访问"/a"路径的请求，可直接访问
                .mvcMatchers(HttpMethod.POST, "/a").permitAll()
                //其他请求都被拒绝（未认证用户返回401，认证用户返回403）
                .anyRequest().denyAll();
    }
}
