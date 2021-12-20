package com.ee.user.servlets;

import com.ee.user.othersServices.ReqScopeClass;
import jakarta.inject.Inject;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/reqScope")
public class ReqScopeServlet extends HttpServlet {
    @Inject
    ReqScopeClass reqScopeClass;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        super.doGet(req, resp);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/javaee/user/reqScope.jsp");
        dispatcher.forward(req, resp);
    }
}
