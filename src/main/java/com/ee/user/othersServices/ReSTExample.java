package com.ee.user.othersServices;

import com.ee.user.model.User;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/restExample")
public class ReSTExample {
    @GET
    @Produces(MediaType.APPLICATION_XML)
    @Path("/xml")
    public User helloXml() {
        return new User("Mi","Mia",44);
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.TEXT_HTML)
    @Path("/json")
    public Response helloJson() {
        return Response.ok(new User("Mi", "Mia", 44), MediaType.APPLICATION_JSON).build();
    }
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/{id}")
    public Integer hello(@PathParam("id") Integer id) {
        return id;
    }
    @POST
    @Produces("text/plain")
    public String helloPost() {
        return "Hello, POST METHOD!";
    }
}
