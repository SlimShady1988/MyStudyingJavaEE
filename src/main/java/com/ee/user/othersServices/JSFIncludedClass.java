package com.ee.user.othersServices;


import jakarta.faces.bean.ManagedBean;

@ManagedBean
public class JSFIncludedClass {
    public String printHello () {
        return "Hello JSF";
    }
}
