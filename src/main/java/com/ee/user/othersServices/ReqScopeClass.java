package com.ee.user.othersServices;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

@RequestScoped
@Named
public class ReqScopeClass {
    private String h;

    public String getH() {
        h = "Hello RequestScope From Bean";
        return h;
    }

    public void setH(String h) {
        this.h = h;
    }
}
