package com.isa.restapidemo.service;

import com.isa.restapidemo.dao.CitizenDaoBean;
import com.isa.restapidemo.dto.CitizenDto;
import com.isa.restapidemo.model.Citizen;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class DoctorService {

    @Inject
    private CitizenDaoBean citizenDaoBean;

    private Citizen provideCitizen(CitizenDto citizenDto) {
        Citizen citizen = new Citizen();
        citizen.setAddress(citizenDto.getAddress());
        citizen.setBirthdate(citizenDto.getBirthdate());
        citizen.setCitizenId(citizenDto.getCitizenId());
        citizen.setDoctor(citizenDto.getDoctor());
        citizen.setIsDoctor(citizenDto.getIsDoctor());
        citizen.setGender(citizenDto.getGender());
        citizen.setName(citizenDto.getName());
        citizen.setSurname(citizenDto.getSurname());
        citizen.setPesel(citizenDto.getPesel());
        citizen.setPatients(citizenDto.getPatients());
        return citizen;
    }

    private CitizenDto provideCitizenDto(Citizen citizen) {
        CitizenDto citizenDto = new CitizenDto();
        citizenDto.setAddress(citizen.getAddress());
        citizenDto.setBirthdate(citizen.getBirthdate());
        citizenDto.setCitizenId(citizen.getCitizenId());
        citizenDto.setDoctor(citizen.getDoctor());
        citizenDto.setIsDoctor(citizen.getIsDoctor());
        citizenDto.setGender(citizen.getGender());
        citizenDto.setName(citizen.getName());
        citizenDto.setSurname(citizen.getSurname());
        citizenDto.setPesel(citizen.getPesel());
        citizenDto.setPatients(citizen.getPatients());
        return citizenDto;
    }

}
