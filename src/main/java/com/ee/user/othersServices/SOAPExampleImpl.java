package com.ee.user.othersServices;

import jakarta.jws.WebService;
import jakarta.xml.ws.Endpoint;

@WebService(endpointInterface = "com.ee.user.othersServices.SOAPExampleInt")
public class SOAPExampleImpl implements SOAPExampleInt {
    public String sayHello() {
        return "Hello World from SOAP 22222222222";
    }

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/javaee-1/webserviceExample", new SOAPExampleImpl());
    }
}

