package com.isa.restapidemo.controller;

import com.isa.restapidemo.dto.CitizenDto;
import com.isa.restapidemo.model.Citizen;
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

    @GET
    public List<CitizenDto> findAllCitizens(@QueryParam("city") String city, @QueryParam("surname")String surname, @QueryParam("province")String province,@QueryParam("postcode")String postCode){
        if(city!=null){
            return citizenService.getCitizensByCity(city);
        }else if(surname!=null){
            return citizenService.getCitizensBySurname(surname);
        }else if(province!=null){
            return citizenService.getCitizensByProvince(province);
        }else if(postCode!=null){
            return citizenService.getCitizensByPostCode(postCode);
        }else{
            return citizenService.getAll();
        }
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
        return citizenService.updateCitizen(citizenId,citizenDto);
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

    @GET
    @Path("/{pesel}")
    public CitizenDto findCitizensBySurname(@PathParam("pesel") String pesel){
        return citizenService.getCitizenByPesel(pesel);
    }




}
