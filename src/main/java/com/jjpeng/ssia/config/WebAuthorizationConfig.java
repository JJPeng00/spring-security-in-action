package com.jjpeng.ssia.config;

import org.springframework.context.annotation.Configuration;
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

        http.authorizeRequests()
                //只有属于ADMIN角色的用户可以访问hello接口
                .mvcMatchers("/hello").hasRole("ADMIN")
                //只有属于MANAGER角色的用户可以访问ciao接口
                .mvcMatchers("ciao").hasRole("MANAGER")
                //规则定义的顺序是由特殊到一般，所以anyRequest()应该处于最后
                //配置只能由认证后的用户访问，未认证用户无法访问，会返回401 Unauthorized
                .anyRequest().authenticated();
    }
}
