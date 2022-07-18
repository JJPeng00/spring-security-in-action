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
                // 选择带有路径变量的endpoint，路径变量还需满足真则表达式，过滤不是数字的字符串
                // curl http://localhost:8080/product/1234a 返回401
                // curl http://localhost:8080/product/12345 返回12345
                .mvcMatchers("/product/{code:^[0-9]*$}").permitAll()
                //其他请求都无需认证
                .anyRequest().permitAll();
    }
}
