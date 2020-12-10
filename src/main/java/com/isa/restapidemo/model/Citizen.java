package com.isa.restapidemo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;
import java.util.Set;

@Entity
public class Citizen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer citizenId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;

    @Column(nullable = true)
    private Date birthdate;

    @Column(nullable = false)
    private Gender gender;

    @Column(unique = true, nullable = false)
    private String pesel;

    @Column(nullable = false)
    private Boolean isDoctor;

    @ManyToOne(fetch = FetchType.EAGER)
    private Citizen doctor;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Citizen> patients;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(referencedColumnName = "addressId")
    private Address address;

    public Citizen() {
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Integer getCitizenId() {
        return citizenId;
    }

    public void setCitizenId(Integer citizenId) {
        this.citizenId = citizenId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public Boolean getIsDoctor() {
        return isDoctor;
    }

    public void setIsDoctor(Boolean doctor) {
        this.isDoctor = doctor;
    }

    public Citizen getDoctor() {
        return doctor;
    }

    public void setDoctor(Citizen doctor) {
        this.doctor = doctor;
    }

    public Set<Citizen> getPatients() {
        return patients;
    }

    public void setPatients(Set<Citizen> patients) {
        this.patients = patients;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Citizen citizen = (Citizen) o;
        return Objects.equals(pesel, citizen.pesel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pesel);
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Citizen{" +
                "citizenId=" + citizenId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", gender=" + gender +
                ", pesel='" + pesel + '\'' +
                ", isDoctor=" + isDoctor +
                ", doctor=" + doctor +
                ", patients=" + patients +
                ", address=" + address +
                '}';
    }
}
