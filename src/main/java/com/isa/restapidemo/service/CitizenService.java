package com.isa.restapidemo.service;

import com.isa.restapidemo.dao.CitizenDaoBean;
import com.isa.restapidemo.dto.CitizenDto;
import com.isa.restapidemo.model.Citizen;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import java.util.Optional;

@RequestScoped
public class CitizenService {

    @Inject
    private CitizenDaoBean citizenDaoBean;

    private Citizen provideCitizen(CitizenDto citizenDto){
        Citizen citizen = new Citizen();
        citizen.setAddress(citizenDto.getAddress());
        citizen.setBirthdate(citizenDto.getBirthdate());
        citizen.setCitizenId(citizenDto.getCitizenId());
        citizen.setDoctor(citizenDto.getDoctor());
        citizen.setDoctor(citizenDto.isDoctor());
        citizen.setGender(citizenDto.getGender());
        citizen.setName(citizenDto.getName());
        citizen.setSurname(citizenDto.getSurname());
        citizen.setPesel(citizenDto.getPesel());
        citizen.setPatients(citizenDto.getPatients());
        return citizen;
    }

    private CitizenDto provideCitizenDto(Citizen citizen){
        CitizenDto citizenDto = new CitizenDto();
        citizenDto.setAddress(citizen.getAddress());
        citizenDto.setBirthdate(citizen.getBirthdate());
        citizenDto.setCitizenId(citizen.getCitizenId());
        citizenDto.setDoctor(citizen.getDoctor());
        citizenDto.setDoctor(citizen.isDoctor());
        citizenDto.setGender(citizen.getGender());
        citizenDto.setName(citizen.getName());
        citizenDto.setSurname(citizen.getSurname());
        citizenDto.setPesel(citizen.getPesel());
        citizenDto.setPatients(citizen.getPatients());
        return citizenDto;
    }

    public CitizenDto saveCitizen(CitizenDto citizenDto){
        Citizen citizen = provideCitizen(citizenDto);
        citizenDaoBean.save(citizen);
        return provideCitizenDto(citizen);
    }

    public boolean removeCitizen(Integer citizenId){
        Citizen citizen = citizenDaoBean.getById(citizenId);
        if (citizen == null){
            return false;
        }else{
            citizenDaoBean.remove(citizen);
            return true;
        }
    }

    public CitizenDto updateCitizen(Integer citizenId, CitizenDto citizenDto){
        Citizen citizen = citizenDaoBean.getById(citizenId);
        Citizen updatedCitizen = provideCitizen(citizenDto);
        citizen.setAddress(updatedCitizen.getAddress());
        citizen.setBirthdate(updatedCitizen.getBirthdate());
        citizen.setCitizenId(updatedCitizen.getCitizenId());
        citizen.setDoctor(updatedCitizen.getDoctor());
        citizen.setDoctor(updatedCitizen.isDoctor());
        citizen.setGender(updatedCitizen.getGender());
        citizen.setName(updatedCitizen.getName());
        citizen.setSurname(updatedCitizen.getSurname());
        citizen.setPesel(updatedCitizen.getPesel());
        citizen.setPatients(updatedCitizen.getPatients());
        citizenDaoBean.update(citizen);
        return provideCitizenDto(citizen);
    }

    public CitizenDto getCitizenById(Integer citizenId){
        Citizen citizen = citizenDaoBean.getById(citizenId);
        return provideCitizenDto(citizen);
    }



}
