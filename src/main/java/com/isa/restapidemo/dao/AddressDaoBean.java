package com.isa.restapidemo.dao;

import com.isa.restapidemo.model.Address;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Stateless
public class AddressDaoBean implements AddressDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public void save(Address address) {
        entityManager.persist(address);
    }

    @Override
    public void update(Address address) {
        entityManager.merge(address);
    }

    @Override
    public void remove(Address address) {
        entityManager.remove(address);
    }

    @Override
    public List<Address> findAll() {
        return entityManager.createQuery("From Address").getResultList();
    }
}
