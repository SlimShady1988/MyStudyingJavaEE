package com.ee.user.othersServices;

import jakarta.xml.ws.Service;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class SOAPCaller {
    public static void main(String[] args) throws URISyntaxException, MalformedURLException {
        URL url = new URL("http://localhost:8080/javaee-1/webserviceExample");
        QName qName = new QName("http://othersServices.user.ee.com/", "SOAPExampleImplService");
        Service service = Service.create(url, qName);
        SOAPExampleInt port = service.getPort(SOAPExampleInt.class);
        System.out.println(port.sayHello());
    }
}
