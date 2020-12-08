package com.isa.restapidemo.dao;

import com.isa.restapidemo.model.Address;

public interface AddressDao extends Dao<Address> {

    Address findByAddressId(Integer id);

}
