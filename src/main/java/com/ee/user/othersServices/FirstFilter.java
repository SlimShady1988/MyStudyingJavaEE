package com.ee.user.othersServices;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;
import java.io.IOException;

@WebFilter(value = "/javaee/user/filteredPage", initParams = {@WebInitParam( name = "Victor", value = "Nazarkiv", description = "dsa")} )
public class FirstFilter implements Filter {
    String name;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        name = filterConfig.getInitParameter("Victor");
        System.out.println(name);
//        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.getWriter().write("before " + name + " ");
        filterChain.doFilter(servletRequest, servletResponse);
        servletResponse.getWriter().write(" after");

    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }
}
