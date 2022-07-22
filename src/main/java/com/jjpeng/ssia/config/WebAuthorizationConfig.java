package com.jjpeng.ssia.config;

import com.jjpeng.ssia.csrf.CustomCsrfTokenRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;

import java.util.List;

/**
 * @author JJPeng
 * @date 2022/7/10 19:48
 */
@Configuration
public class WebAuthorizationConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public CsrfTokenRepository customTokenRepository() {
        return new CustomCsrfTokenRepository();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.cors(c -> {
            CorsConfigurationSource source = request -> {
                CorsConfiguration config = new CorsConfiguration();
                config.setAllowedOrigins(
                        List.of("example.com", "example.org"));
                //默认不会Allowed任何方法，必须指定需要allow的http方法
                config.setAllowedMethods(
                        List.of("GET", "POST", "PUT", "DELETE"));
                return config;
            };
            c.configurationSource(source);
        });

        //禁用csrf，只用关心cors
        http.csrf().disable();

        http.authorizeRequests()
                .anyRequest().permitAll();
    }
}
