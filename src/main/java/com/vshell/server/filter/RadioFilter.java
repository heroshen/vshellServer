package com.vshell.server.filter;

import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * Created by heroshen on 2017/12/13.
 */
@Order(1)
@WebFilter(filterName = "radioFilter", urlPatterns = "/radio/*")
public class RadioFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("getServerName"+servletRequest.getServerName());
        System.out.println("getLocalAddr"+servletRequest.getLocalAddr());
        System.out.println("getLocalName"+servletRequest.getLocalName());
        System.out.println("getProtocol"+servletRequest.getProtocol());
        System.out.println("getRemoteAddr"+servletRequest.getRemoteAddr());
        System.out.println("getRemoteHost"+servletRequest.getRemoteHost());
        System.out.println("getServerPort"+servletRequest.getServerPort());
        System.out.println("getParameterMap"+servletRequest.getParameterMap());

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
