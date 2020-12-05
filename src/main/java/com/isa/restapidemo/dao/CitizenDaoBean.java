package com.isa.restapidemo.dao;

import com.isa.restapidemo.model.Citizen;

import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Transactional
@Stateless
public class CitizenDaoBean implements CitizenDao {



    @Override
    public void save(Citizen citizen) {

    }

    @Override
    public void update(Citizen citizen) {

    }

    @Override
    public void remove(Citizen citizen) {

    }

    @Override
    public List<Citizen> findAll() {
        return null;
    }

    @Override
    public Optional<Citizen> getByPesel(String pesel) {
        return Optional.empty();
    }

    @Override
    public Optional<Citizen> getBySurname(String surname) {
        return Optional.empty();
    }

    @Override
    public Optional<Citizen> getByDoctorPesel(String pesel) {
        return Optional.empty();
    }

    @Override
    public Optional<Citizen> getByDoctorSurname(String surname) {
        return Optional.empty();
    }

    @Override
    public Optional<Citizen> getById(Integer id) {
        return Optional.empty();
    }

    @Override
    public List<Citizen> getPatients() {
        return null;
    }

    @Override
    public List<Citizen> getDoctors() {
        return null;
    }

    @Override
    public List<Citizen> getByProvince(String province) {
        return null;
    }

    @Override
    public List<Citizen> getByCity(String city) {
        return null;
    }

    @Override
    public List<Citizen> getByPostCode(String postcode) {
        return null;
    }
}
