//package com.ee.user.othersServices;
//
//import javax.enterprise.inject.spi.Bean;
//import javax.enterprise.inject.spi.BeanManager;
//import jakarta.inject.Named;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServlet;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import jakarta.inject.Inject;
//import jakarta.servlet.annotation.WebServlet;
//import org.apache.webbeans.config.WebBeansContext;
//import org.apache.webbeans.spi.ContainerLifecycle;
//
//import java.io.IOException;
//
//
//@WebServlet(name = "openWebBean", urlPatterns = "/openWebBean")
//public class OpenWebBeans extends HttpServlet {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.getWriter().println("Look into your console. There are is method print from called bean");
//        ContainerLifecycle lifeCycle = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
//        lifeCycle.startApplication(null);
//        BeanManager beanManager = lifeCycle.getBeanManager();
//        Bean<?> bean = beanManager.getBeans("myContainer").iterator().next();
//        MyContainer myContainer = (MyContainer) lifeCycle.getBeanManager().getReference(bean, MyContainer.class, beanManager.createCreationalContext(bean));
//        myContainer.runBean();
//        lifeCycle.stopApplication(null);
//    }
//}
//
//@Named
//class MyContainer {
//    @Inject
//    MyBean myBean;
//    public void runBean () {
//        myBean.print();
//    }
//}
//
//class MyBean {
//    public void print () {
//        System.out.println("Open Web Bean");
//    }
//}
