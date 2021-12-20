package com.ee.user.othersServices;

import jakarta.ws.rs.client.*;
import jakarta.ws.rs.core.Response;

import java.net.URI;
import java.net.URISyntaxException;

public class ReSTClient {
    public static void main(String[] args) throws URISyntaxException {
        Client client = ClientBuilder.newClient();
        URI uri = new URI("http://localhost:8080/javaee-1/restExample");
        WebTarget target = client.target(uri);
//        Invocation invocation = target.request().buildPost(Entity.text("xoxoxoxo"));
        Invocation invocation = target.request().buildGet();
        Response response = invocation.invoke();
        if (response.getStatusInfo().getStatusCode() == Response.Status.OK.getStatusCode()) {
            String resp = response.readEntity(String.class);
            System.out.println(resp);
        }
        client.close();

    }
}
