package com.jjpeng.ssia.filter;

import org.springframework.security.web.csrf.CsrfToken;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.Logger;

/**
 * @author JJPeng
 * @date 2022/7/20 22:02
 */
public class CsrfTokenLoggerFilter implements Filter {
    private Logger logger = Logger.getLogger(CsrfTokenLoggerFilter.class.getName());

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CsrfToken csrf = (CsrfToken) servletRequest.getAttribute("_csrf");
        String token = csrf.getToken();

        logger.info("CSRF token: " + token);
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
