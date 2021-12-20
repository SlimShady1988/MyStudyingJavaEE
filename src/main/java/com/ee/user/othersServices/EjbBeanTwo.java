package com.ee.user.othersServices;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;

@Singleton
public class EjbBeanTwo {
    @PostConstruct
    public void firstMethod() {
        System.out.println("Second Bean was started");
    }
}
