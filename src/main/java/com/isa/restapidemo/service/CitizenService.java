package com.isa.restapidemo.service;

import com.isa.restapidemo.dao.CitizenDao;
import com.isa.restapidemo.dao.CitizenDaoBean;
import com.isa.restapidemo.dto.CitizenDto;
import com.isa.restapidemo.model.Citizen;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestScoped
public class CitizenService {

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

    @Transactional
    public CitizenDto saveCitizen(CitizenDto citizenDto) {
        Citizen citizen = provideCitizen(citizenDto);
        citizenDaoBean.save(citizen);
        return provideCitizenDto(citizen);
    }

    @Transactional
    public boolean removeCitizen(Integer citizenId) {
        Citizen citizen = citizenDaoBean.getById(citizenId);
        if (citizen == null) {
            return false;
        } else {
            citizenDaoBean.remove(citizen);
            return true;
        }
    }

    @Transactional
    public CitizenDto updateCitizen(Integer citizenId, CitizenDto citizenDto) {
        Citizen citizen = citizenDaoBean.getById(citizenId);
        Citizen updatedCitizen = provideCitizen(citizenDto);
        citizen.setAddress(updatedCitizen.getAddress());
        citizen.setBirthdate(updatedCitizen.getBirthdate());
        citizen.setCitizenId(updatedCitizen.getCitizenId());
        citizen.setDoctor(updatedCitizen.getDoctor());
        citizen.setIsDoctor(updatedCitizen.getIsDoctor());
        citizen.setGender(updatedCitizen.getGender());
        citizen.setName(updatedCitizen.getName());
        citizen.setSurname(updatedCitizen.getSurname());
        citizen.setPesel(updatedCitizen.getPesel());
        citizen.setPatients(updatedCitizen.getPatients());
        citizenDaoBean.update(citizen);
        return provideCitizenDto(citizen);
    }

    @Transactional
    public CitizenDto getCitizenById(Integer citizenId) {
        Citizen citizen = citizenDaoBean.getById(citizenId);
        return provideCitizenDto(citizen);
    }

    @Transactional
    public List<CitizenDto> getAll() {
        List<Citizen> citizens = citizenDaoBean.findAll();
        return citizens.stream()
                .map(this::provideCitizenDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CitizenDto> getCitizensBySurname(String surname) {
        List<Citizen> citizens = citizenDaoBean.getBySurname(surname);
        return citizens.stream()
                .map(this::provideCitizenDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public CitizenDto getCitizenByPesel(String pesel) {
        Citizen citizen = citizenDaoBean.getByPesel(pesel).get();
        return provideCitizenDto(citizen);
    }

    @Transactional
    public List<CitizenDto> getCitizensByProvince(String province) {
        List<Citizen> citizenList = citizenDaoBean.getByProvince(province);
        return citizenList.stream()
                .map(this::provideCitizenDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CitizenDto> getCitizensByCity(String city) {
        List<Citizen> citizenList = citizenDaoBean.getByCity(city);
        return citizenList.stream()
                .map(this::provideCitizenDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<CitizenDto> getCitizensByPostCode(String postCode) {
        List<Citizen> citizenList = citizenDaoBean.getByPostCode(postCode);
        return citizenList.stream()
                .map(this::provideCitizenDto)
                .collect(Collectors.toList());
    }
}
