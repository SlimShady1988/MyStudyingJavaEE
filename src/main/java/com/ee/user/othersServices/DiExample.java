package com.ee.user.othersServices;

import jakarta.enterprise.inject.Produces;
import jakarta.inject.Inject;
import jakarta.inject.Qualifier;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@WebServlet("/diExample")
public class DiExample  extends HttpServlet {
    @Inject
    String s;

    @Inject
    @S2
    String s2;

    @Inject
    int i;

    @Inject
    double d;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(s);

        resp.getWriter().write(s + " " + s2 + " " + i + " " + d );

    }
}

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@interface S2{}

class Producer {
    @Produces
    String s = "hello DI";
    @Produces
    @S2
    String s2 = "hello DI-2";
    @Produces
    int i = 5;

    @Produces
    double getDouble() {
        return 1 + 3.3 + 3.7;
    }

    @Produces
    Car getCar() {
        return new Car("BMV");
    }

}

class Car {
    String name;

    public Car(String name) {
        this.name = name;
    }
}

