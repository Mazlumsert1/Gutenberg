/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.rest;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 *
 * @author Private
 */
@Path("mysql")
public class MySQLAPI {

    Gson gson;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestService
     */
    public MySQLAPI() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .create();
    }
    
    @GET
    @Path("test")
    public Response testApi() {
        
        return Response.status(Response.Status.OK).entity("hey hvasså").build();
    }

    @GET
    @Path("bookslatlong")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getBooksFromLatLong() {

        return Response.status(Response.Status.OK).entity("").build();
    }

}
