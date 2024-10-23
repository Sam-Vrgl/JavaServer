package com.example.app.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/")
public class LevelZeroResource {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String index() {
        return "<h1>Welcome to Level Zero</h1>" +
                "<p>Samuel Vergnol</p>" +
                "<ul>" +
                "<li><a href=\"hello\">Hello</a></li>" +
                "<li><a href=\"ping\">Ping</a></li>" +
                "</ul>";
    }

    @GET
    @Path("/hello")
    @Produces(MediaType.TEXT_HTML)
    public String hello() {
        return "<h1>Hello World</h1>";
    }

    @GET
    @Path("/ping")
    @Produces(MediaType.APPLICATION_JSON)
    public Response ping() {
        String jsonResponse = "{\"message\": \"pong\"}";
        return Response.ok(jsonResponse, MediaType.APPLICATION_JSON).build();
    }

}
