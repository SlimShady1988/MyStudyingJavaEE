package com.ee.user.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.context.Context;
//import org.thymeleaf.templateresolver.TemplateResolver;

import java.io.IOException;
import java.io.StringWriter;

@WebServlet(name ="usersList", urlPatterns = "/user/usersList")
public class UsersListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        TemplateResolver templateResolver = new TemplateResolver();
//        TemplateEngine templateEngine = new TemplateEngine();
////        templateEngine.initialize();
//        System.out.println(templateEngine.getConfiguration());
//        templateResolver.setPrefix("/javaee/user/templates/");
//        templateResolver.setSuffix(".html");
//        templateResolver.setTemplateMode("HTML5");
//        System.out.println("create:templateResolver");
//        templateEngine.setTemplateResolver(templateResolver);
//
//        Context context = new Context();
//        context.setVariable("name", "World");
//        StringWriter stringWriter = new StringWriter();
//        templateEngine.process("usersList.html", context, stringWriter);
        req.getRequestDispatcher("/javaee/user/templates/usersList.html").forward(req, resp);
    }
}
