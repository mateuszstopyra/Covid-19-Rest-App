package com.isa.restapidemo.service;

import com.isa.restapidemo.dao.CitizenDaoBean;
import com.isa.restapidemo.dto.CitizenDto;
import com.isa.restapidemo.dto.PatientDto;
import com.isa.restapidemo.model.Citizen;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class PatientService {

    @Inject
    private CitizenDaoBean citizenDaoBean;

    private Citizen providePatient(PatientDto patientDto) {
        Citizen patient = new Citizen();
        patient.setAddress(patientDto.getAddress());
        patient.setBirthdate(patientDto.getBirthdate());
        patient.setCitizenId(patientDto.getCitizenId());
        patient.setDoctor(patientDto.getDoctor());
        patient.setIsDoctor(patientDto.getIsDoctor());
        patient.setGender(patientDto.getGender());
        patient.setName(patientDto.getName());
        patient.setSurname(patientDto.getSurname());
        patient.setPesel(patientDto.getPesel());
        return patient;
    }

    private PatientDto provideCitizenDto(Citizen patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setAddress(patient.getAddress());
        patientDto.setBirthdate(patient.getBirthdate());
        patientDto.setCitizenId(patient.getCitizenId());
        patientDto.setDoctor(patient.getDoctor());
        patientDto.setIsDoctor(patient.getIsDoctor());
        patientDto.setGender(patient.getGender());
        patientDto.setName(patient.getName());
        patientDto.setSurname(patient.getSurname());
        patientDto.setPesel(patient.getPesel());
        return patientDto;
    }




}
