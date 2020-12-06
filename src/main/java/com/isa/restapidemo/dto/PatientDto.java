package com.isa.restapidemo.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.isa.restapidemo.model.Address;
import com.isa.restapidemo.model.Citizen;
import com.isa.restapidemo.model.Gender;

import java.util.Date;
import java.util.Set;

public class PatientDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer citizenId;

    private String name;

    private String surname;

    private Gender gender;

    @JsonFormat(pattern = "yyyy-MM-dd", shape = JsonFormat.Shape.STRING)
    private Date birthdate;

    private String pesel;

    private boolean isDoctor;

    private Citizen doctor;

    private Address address;

    public PatientDto(Integer citizenId, String name, String surname, Gender gender, Date birthdate, String pesel, boolean isDoctor, Citizen doctor, Address address) {
        this.citizenId = citizenId;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.birthdate = birthdate;
        this.pesel = pesel;
        this.isDoctor = isDoctor;
        this.doctor = doctor;
        this.address = address;
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

    public Citizen getDoctor() {
        return doctor;
    }

    public void setDoctor(Citizen doctor) {
        this.doctor = doctor;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PatientDto{" +
                "citizenId=" + citizenId +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", gender=" + gender +
                ", birthdate=" + birthdate +
                ", pesel='" + pesel + '\'' +
                ", isDoctor=" + isDoctor +
                ", doctor=" + doctor +
                ", address=" + address +
                '}';
    }
}
