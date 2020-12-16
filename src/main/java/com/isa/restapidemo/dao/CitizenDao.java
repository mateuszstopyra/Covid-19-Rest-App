package com.isa.restapidemo.dao;

import com.isa.restapidemo.model.Citizen;

import java.util.List;
import java.util.Optional;

public interface CitizenDao extends Dao<Citizen> {

    Optional<Citizen> getByPesel(String pesel);

    List<Citizen> getBySurname(String surname);

    Optional<Citizen> getByDoctorPesel(String pesel);

    Citizen getById(Integer id);

    List<Citizen> getPatients();

    List<Citizen> getDoctors();

    List<Citizen> getByProvince(String province);

    List<Citizen> getByCity(String city);

    List<Citizen> getByPostCode(String postcode);

    Citizen getDoctorById(Integer id);



}
