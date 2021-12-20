package com.ee.user.servlets;

import com.ee.user.othersServices.SOAPExampleInt;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.xml.ws.WebServiceRef;

import java.io.IOException;

@WebServlet(name = "SOAPServlet", urlPatterns = "/SOAPServlet")
public class SOAPServlet extends HttpServlet {
    @WebServiceRef
//    @WebServiceRef(wsdlLocation = "http://othersServices.user.ee.com/")
    SOAPExampleInt soapExampleInt;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet is working");

        String message = soapExampleInt.sayHello();
        resp.getWriter().write(message);
    }
}
