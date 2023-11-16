package com.demo.api.api;

import com.demo.api.dao.ResvervationDAO;
import com.demo.api.dao.SpectacleDAO;
import com.demo.api.model.Reservation;
import com.demo.api.model.Spectacle;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.ArrayList;
import java.util.List;

@Path("/spectacles")
public class SpectaclesApi {

    private SpectacleDAO spectacleDAO = SpectacleDAO.getInstance();
    private ResvervationDAO resvervationDAO = ResvervationDAO.getInstance();

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


    @GET
    @Path("/{id}/reservations")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReservationsConfirmees(@PathParam("id") Integer id){
        if(!spectacleDAO.exist(id))
            return Response.status(Response.Status.NOT_FOUND).build();
        else
            return Response.ok()
                    .entity(resvervationDAO.getReservationsConfirmees(id)).build();
    }
}