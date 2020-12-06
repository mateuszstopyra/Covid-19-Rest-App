package com.isa.restapidemo.service;

import com.isa.restapidemo.dao.AddressDao;
import com.isa.restapidemo.dao.AddressDaoBean;
import com.isa.restapidemo.dto.AddressDto;
import com.isa.restapidemo.model.Address;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class AddressService {

    @Inject
    AddressDaoBean addressDaoBean;

    private AddressDto provideAddressDto(Address address){
        AddressDto addressDto = new AddressDto();
        addressDto.setAddressId(address.getAddressId());
        addressDto.setApartmentNumber(address.getApartmentNumber());
        addressDto.setCity(address.getCity());
        addressDto.setHouseNumber(address.getHouseNumber());
        addressDto.setPatients(address.getPatients());
        addressDto.setProvince(address.getProvince());
        addressDto.setPostCode(address.getPostCode());
        addressDto.setStreet(address.getStreet());
        return addressDto;
    }

    private Address provideAddress(AddressDto addressDto){
        Address address = new Address();
        address.setAddressId(addressDto.getAddressId());
        address.setApartmentNumber(addressDto.getApartmentNumber());
        address.setCity(addressDto.getCity());
        address.setHouseNumber(addressDto.getHouseNumber());
        address.setPatients(addressDto.getPatients());
        address.setProvince(addressDto.getProvince());
        address.setPostCode(addressDto.getPostCode());
        address.setStreet(addressDto.getStreet());
        return address;
    }



}
