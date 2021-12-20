package com.ee.user.othersServices;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import java.util.Enumeration;

public class ReqListener implements ServletRequestListener {
    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        System.out.println("Listener is working");
        Enumeration<String> attributeNames = sre.getServletRequest().getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String atr = attributeNames.nextElement();
            System.out.println(atr);
        }
//        ServletRequestListener.super.requestInitialized(sre);
    }

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        ServletRequestListener.super.requestDestroyed(sre);
    }
}