package com.ee.user.othersServices;

import jakarta.annotation.Priority;
import jakarta.decorator.Decorator;
import jakarta.decorator.Delegate;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Any;
import jakarta.inject.Inject;
import jakarta.inject.Qualifier;
import jakarta.interceptor.Interceptor;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@WebServlet( name = "decorator", urlPatterns = "/decorator")
public class DecoratorExample  extends HttpServlet {

    @Inject
    Parent parent;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        parent.print();
    }
}

interface Parent {
    void print();
}

class Child implements Parent {
    @Override
    public void print() {
        System.out.println("Method Print from child is Working");
    }
}

@Priority(Interceptor.Priority.APPLICATION)
@Decorator
class DecoratorUse implements Parent {
    @Inject
    @Delegate
//    @Any
    Parent p;

    @Override
    public void print() {
        System.out.println("Before");
        p.print();
    }
}


