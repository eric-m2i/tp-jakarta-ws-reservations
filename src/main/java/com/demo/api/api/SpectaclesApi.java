package com.demo.api.api;

import com.demo.api.dao.SpectacleDAO;
import com.demo.api.model.Spectacle;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/spectacles")
public class SpectaclesApi {

    private SpectacleDAO spectacleDAO = SpectacleDAO.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Spectacle> getSpectacles() {
        return spectacleDAO.getSpectacles();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postSpectacle(Spectacle spectacle) {
        spectacleDAO.addSpectacle(spectacle);
        return Response.ok().build();
    }
}