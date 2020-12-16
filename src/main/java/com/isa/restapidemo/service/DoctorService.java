package com.isa.restapidemo.service;

import com.isa.restapidemo.dao.CitizenDaoBean;
import com.isa.restapidemo.dto.CitizenDto;
import com.isa.restapidemo.dto.DoctorDto;
import com.isa.restapidemo.dto.PatientDto;
import com.isa.restapidemo.model.Citizen;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.print.Doc;
import javax.transaction.Transactional;

@RequestScoped
public class DoctorService {

    @Inject
    private CitizenDaoBean citizenDaoBean;

    private Citizen provideDoctor(DoctorDto doctorDto) {
        Citizen doctor = new Citizen();
        doctor.setAddress(doctorDto.getAddress());
        doctor.setBirthdate(doctorDto.getBirthdate());
        doctor.setCitizenId(doctorDto.getCitizenId());
        doctor.setIsDoctor(doctorDto.getIsDoctor());
        doctor.setGender(doctorDto.getGender());
        doctor.setName(doctorDto.getName());
        doctor.setSurname(doctorDto.getSurname());
        doctor.setPesel(doctorDto.getPesel());
        doctor.setPatients(doctorDto.getPatients());
        return doctor;
    }

    private DoctorDto provideDoctorDto(Citizen doctor) {
        DoctorDto doctorDto = new DoctorDto();
        doctorDto.setAddress(doctor.getAddress());
        doctorDto.setBirthdate(doctor.getBirthdate());
        doctorDto.setCitizenId(doctor.getCitizenId());
        doctorDto.setIsDoctor(doctor.getIsDoctor());
        doctorDto.setGender(doctor.getGender());
        doctorDto.setName(doctor.getName());
        doctorDto.setSurname(doctor.getSurname());
        doctorDto.setPesel(doctor.getPesel());
        doctorDto.setPatients(doctor.getPatients());
        return doctorDto;
    }

    @Transactional
    public DoctorDto addDoctor(DoctorDto doctorDto){
        Citizen doctor = provideDoctor(doctorDto);
        citizenDaoBean.save(doctor);
        return provideDoctorDto(doctor);
    }

    @Transactional
    public DoctorDto getDoctorById(Integer doctorId){
        Citizen doctor = citizenDaoBean.getDoctorById(doctorId).get();
        return provideDoctorDto(doctor);
    }

    @Transactional
    public DoctorDto updateDoctor(Integer doctorId, DoctorDto doctorDto){
        Citizen doctor = citizenDaoBean.getDoctorById(doctorId).get();
        Citizen updateDoctor = provideDoctor(doctorDto);
        doctor.setAddress(updateDoctor.getAddress());
        doctor.setBirthdate(updateDoctor.getBirthdate());
        doctor.setIsDoctor(updateDoctor.getIsDoctor());
        doctor.setPatients(updateDoctor.getPatients());
        doctor.setGender(updateDoctor.getGender());
        doctor.setName(updateDoctor.getName());
        doctor.setSurname(updateDoctor.getSurname());
        doctor.setPesel(updateDoctor.getPesel());
        citizenDaoBean.update(doctor);
        return provideDoctorDto(doctor);
    }

    @Transactional
    public boolean removeDoctor(Integer doctorId) {
        Citizen doctor = citizenDaoBean.getDoctorById(doctorId).get();
        if (doctor == null) {
            return false;
        } else {
            citizenDaoBean.remove(patient);
            return true;
        }
    }



}
