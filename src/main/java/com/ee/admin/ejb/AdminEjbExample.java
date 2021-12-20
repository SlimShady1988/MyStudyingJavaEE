package com.ee.admin.ejb;

import jakarta.annotation.security.RolesAllowed;
import jakarta.ejb.Singleton;

@Singleton
@RolesAllowed({"admin"})
public class AdminEjbExample {
    public void doo () {
        System.out.println("Welcome Admin");
    }
}
