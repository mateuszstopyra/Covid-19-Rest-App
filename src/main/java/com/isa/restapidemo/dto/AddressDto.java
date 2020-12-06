package com.isa.restapidemo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.isa.restapidemo.model.Citizen;

import java.util.Set;

public class AddressDto {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer addressId;

    private String province;

    private String city;

    private String postCode;

    private String street;

    private Integer houseNumber;

    private Integer apartmentNumber;

    @JsonIgnore
    private Set<Citizen> patients;

    public AddressDto(){
    }

    @Override
    public String toString() {
        return "AddressDto{" +
                "addressId=" + addressId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", postCode='" + postCode + '\'' +
                ", street='" + street + '\'' +
                ", houseNumber=" + houseNumber +
                ", apartmentNumber=" + apartmentNumber +
                ", citizens=" + patients +
                '}';
    }

    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public Integer getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(Integer houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getApartmentNumber() {
        return apartmentNumber;
    }

    public void setApartmentNumber(Integer apartmentNumber) {
        this.apartmentNumber = apartmentNumber;
    }

    public Set<Citizen> getPatients() {
        return patients;
    }

    public void setPatients(Set<Citizen> patients) {
        this.patients = patients;
    }
}
