package com.ee.user.othersServices;

import jakarta.enterprise.inject.Specializes;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


@WebServlet(name = "specializeAnnotation", urlPatterns = "/specializeAnnotation")
public class SpecializeAnnotation extends HttpServlet {
    @Inject
    A a;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        a.print();
    }
}

interface A {
 void print ();
}

class B implements A {
    @Override
    public void print() {
        System.out.println("Class B");
    }
}
@Specializes
class C extends B {
    @Override
    public void print() {
        System.out.println("Class C");
    }
}
