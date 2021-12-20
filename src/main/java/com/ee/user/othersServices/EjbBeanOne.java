package com.ee.user.othersServices;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.DependsOn;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;

@Singleton
@Startup
@DependsOn("EjbBeanTwo")
public class EjbBeanOne {
    @PostConstruct
    public void firstMethod () {
        System.out.println("First bean was started");
    }
}
