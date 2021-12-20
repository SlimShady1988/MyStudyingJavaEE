package com.ee.admin.servlets;

import com.ee.admin.model.Admin;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin/*")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 7413477891828475982L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ServletException {
        Admin admin = new Admin(33, "Victor", "Nazarkiv");

        req.setAttribute("Admin", admin);
        req.getSession().setAttribute("Admin", admin);
        req.getServletContext().setAttribute("Admin", admin);

        req.getRequestDispatcher("/javaee/admin/adminView.jsp").forward(req, resp);

    }
}
