package com.isa.restapidemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isa.restapidemo.model.Address;
import com.isa.restapidemo.model.Citizen;

import javax.persistence.*;
import java.util.Set;

public class CitizenDto {

    private Integer citizenId;

    private String name;

    private String surname;

    private String pesel;

    private boolean isDoctor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Citizen doctor;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Citizen> patients;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "addressId")
    private Address address;

}
