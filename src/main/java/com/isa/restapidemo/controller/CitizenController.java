package com.isa.restapidemo.controller;

import com.isa.restapidemo.dto.CitizenDto;
import com.isa.restapidemo.service.CitizenService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/citizen")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CitizenController {

    @Inject
    CitizenService citizenService;

    //TODO
    @GET
    public List<CitizenDto> findAllCitizens(){
        return citizenService.getAll();
    }

    @GET
    @Path("/{id}")
    public CitizenDto findCitizenById(@PathParam("id") Integer citizenId){
        return citizenService.getCitizenById(citizenId);
    }

    @POST
    public CitizenDto saveCitizen(CitizenDto citizenDto){
        return citizenService.saveCitizen(citizenDto);
    }

    @PUT
    @Path("/{id}")
    public CitizenDto updateCitizen(@PathParam("id") Integer citizenId, CitizenDto citizenDto){
        return citizenService.saveCitizen(citizenDto);
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCitizen(@PathParam("id")Integer citizenId){
        if(citizenService.removeCitizen(citizenId)){
            return Response.accepted().build();
        }else{
            return Response.status(404).build();
        }
    }



}
