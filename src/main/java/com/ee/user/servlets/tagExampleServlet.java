package com.ee.user.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "tagExample", urlPatterns = "/user/tryTagJSP")
public class tagExampleServlet extends HttpServlet {
    private static final long serialVersionUID = -5212775540631881855L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("tagExample.jsp").forward(req, resp);
    }
}
