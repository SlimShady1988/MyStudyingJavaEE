package com.ee;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(servletNames = "FilterServlet")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("Filter is Initiated");

    }

    @Override
    public void destroy() {
        System.out.println("Filter is Destroyed");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter is Working");
        String remoteHost = servletRequest.getRemoteHost();
        System.out.println(remoteHost);
        filterChain.doFilter(servletRequest, servletResponse);

    }
}