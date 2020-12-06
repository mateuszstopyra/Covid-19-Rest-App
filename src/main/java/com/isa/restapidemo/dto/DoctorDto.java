package com.isa.restapidemo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.isa.restapidemo.model.Address;
import com.isa.restapidemo.model.Citizen;
import com.isa.restapidemo.model.Gender;

import java.util.Set;

public class DoctorDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer citizenId;

    private String name;

    private String surname;

    private Gender gender;

    private String pesel;

    private boolean isDoctor;

    private Set<Citizen> patients;

    private Address address;

    public DoctorDto(Integer citizenId, String name, String surname, Gender gender, String pesel, boolean isDoctor, Set<Citizen> patients, Address address) {
        this.citizenId = citizenId;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.pesel = pesel;
        this.isDoctor = isDoctor;
        this.patients = patients;
        this.address = address;
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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public boolean isDoctor() {
        return isDoctor;
    }

    public void setDoctor(boolean doctor) {
        isDoctor = doctor;
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
    public String toString() {
        return "DoctorDto{" +
                "citizenId=" + citizenId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", pesel='" + pesel + '\'' +
                ", isDoctor=" + isDoctor +
                ", patients=" + patients +
                ", address=" + address +
                '}';
    }
}
