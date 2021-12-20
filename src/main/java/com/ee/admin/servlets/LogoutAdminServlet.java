package com.ee.admin.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LogoutAdminServlet", urlPatterns = "/admin/logout")
public class LogoutAdminServlet extends HttpServlet {
    private static final long serialVersionUID = 7413477891828475982L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        req.getRequestDispatcher("/javaee/admin/adminView.jsp").forward(req, resp);
    }

}
