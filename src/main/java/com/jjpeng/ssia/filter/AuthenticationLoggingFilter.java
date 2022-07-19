package com.jjpeng.ssia.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author JJPeng
 * @date 2022/7/19 21:58
 */
public class AuthenticationLoggingFilter implements Filter {

    private final Logger logger = Logger.getLogger(AuthenticationLoggingFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest)servletRequest;
        String requestId = httpServletRequest.getHeader("Request-Id");

        logger.info("Successfully authenticated request with id " + requestId);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
