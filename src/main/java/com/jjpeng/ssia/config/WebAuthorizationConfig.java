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
                // 使用路径表达式选择匹配适合规则的路径（以/a/b未前缀的路径都需要认证），**表示任何数量的路径
                // 使用路径表达式可以让代码更简洁
                .mvcMatchers("/a/b/**").authenticated()
                //其他请求都无需认证
                .anyRequest().permitAll();
    }
}
