package com.jjpeng.ssia.filter;


import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author JJPeng
 * @date 2022/7/19 21:58
 *
 * Spring Security提供了一些实现了Filter接口的抽象类
 * 当我们需要实现某一功能是，优先考虑是否可以通过拓展Spring Security提供的抽象类来是实现功能
 *
 * 因为Spring Security并不能保证每一个过滤器不被多次调用，所以我们需要在过滤器中自己实现，OncePerRequestFilter是Spring Security实现的抽象类，该类保证此过滤器在一次请求中只被调用一次，我们通过拓展该类实现我们的功能
 *
 * 还可以通过重写OncePerRequestFilter中的其他方法实现其他实用的功能
 */
public class AuthenticationLoggingFilter extends OncePerRequestFilter {

    private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String requestId = httpServletRequest.getHeader("Request-Id");

        logger.info("Successfully authenticated request with id " + requestId);
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
