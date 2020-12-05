package com.isa.restapidemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(unique = true, nullable = false)
    private String pesel;

    private boolean isDoctor;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    private Citizen doctor;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER)
    private Set<Citizen> patients;

    @ManyToOne(fetch = FetchType.EAGER)
    private Address address;



}
