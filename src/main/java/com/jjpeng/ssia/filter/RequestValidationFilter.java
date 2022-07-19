package com.jjpeng.ssia.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author JJPeng
 * @date 2022/7/19 21:31
 *
 * 自定义过滤器：
 *      判断请求带有名为Request-Id的请求头
 *      如果有，就传递到下一个过滤器
 *      如果没有就直接返回400
 */
public class RequestValidationFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;

        String requestId = httpServletRequest.getHeader("Request-Id");

        if (requestId == null || requestId.isBlank()) {
            httpServletResponse.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }
}
