package com.ee.user.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FilterServlet", urlPatterns = "/user/filteredPage")
public class FilterServlet extends HttpServlet {


    private static final long serialVersionUID = 505730750250263325L;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("servlet");
    }

    @Override
    public void destroy() {
        super.destroy();
    }
}
