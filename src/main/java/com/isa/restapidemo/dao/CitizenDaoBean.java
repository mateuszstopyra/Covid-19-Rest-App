package com.isa.restapidemo.dao;

import com.isa.restapidemo.model.Citizen;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RequestScoped
public class CitizenDaoBean implements CitizenDao {

    private static final Logger LOG = Logger.getLogger(CitizenDaoBean.class.getName());

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Citizen citizen) {
        entityManager.persist(citizen);
    }

    @Override
    public void update(Citizen citizen) {
        entityManager.merge(citizen);
    }

    @Override
    public void remove(Citizen citizen) {
        entityManager.remove(citizen);
    }

    @Override
    public List<Citizen> findAll() {
        return entityManager.createQuery("From Citizen").getResultList();
    }

    @Override
    public Optional<Citizen> getByPesel(String pesel) {
        try {
            TypedQuery<Citizen> query = entityManager.createQuery("select p from Citizen p where p.pesel= :pesel", Citizen.class);
            query.setParameter("pesel", pesel);
            return Optional.ofNullable(query.getSingleResult());
        }catch(NoResultException e){
            LOG.info(e.getMessage());
            return Optional.empty();
        }
    }

    @Override
    public List<Citizen> getBySurname(String surname) {
            TypedQuery<Citizen> query = entityManager.createQuery("select p from Citizen p where p.surname= :surname", Citizen.class);
            query.setParameter("surname", surname);
            return query.getResultList();
    }

    @Override
    public Optional<Citizen> getByDoctorPesel(String pesel) {
        Optional<Citizen> citizen = getByPesel(pesel);
        if(citizen.get().getIsDoctor()){
            return citizen;
        }else{
            LOG.info("No doctor with this pesel");
            return Optional.empty();
        }
    }

    @Override
    public Optional<Citizen> getDoctorById(Integer id) {
        Optional<Citizen> doctor = Optional.ofNullable(getById(id));
        if(doctor.get().getIsDoctor()){
            return doctor;
        }else{
            LOG.info("No doctor with this id");
            return Optional.empty();
        }

    }

    @Override
    public Citizen getById(Integer id) {
        return entityManager.find(Citizen.class,id);
    }

    //TODO
    @Override
    public List<Citizen> getPatients() {
        TypedQuery<Citizen> query = entityManager.createQuery("select p from Citizen p where p.isDoctor= :isDoctor",Citizen.class);
        query.setParameter("isDoctor",false);
        return query.getResultList();
    }

    //TODO
    @Override
    public List<Citizen> getDoctors() {
        TypedQuery<Citizen> query = entityManager.createQuery("select p from Citizen p where p.isDoctor= :isDoctor",Citizen.class);
        query.setParameter("isDoctor",true);
        return query.getResultList();
    }

    @Override
    public List<Citizen> getByProvince(String province) {
        TypedQuery<Citizen> query = entityManager.createQuery("select p from Citizen p where p.address.province= :province",Citizen.class);
        query.setParameter("province",province);
        return query.getResultList();
    }

    @Override
    public List<Citizen> getByCity(String city) {
        TypedQuery<Citizen> query = entityManager.createQuery("select p from Citizen p where p.address.city= :city",Citizen.class);
        query.setParameter("city",city);
        return query.getResultList();
    }

    @Override
    public List<Citizen> getByPostCode(String postCode) {
        TypedQuery<Citizen> query = entityManager.createQuery("select p from Citizen p where p.address.postCode= :postCode",Citizen.class);
        query.setParameter("postCode",postCode);
        return query.getResultList();       }
}
