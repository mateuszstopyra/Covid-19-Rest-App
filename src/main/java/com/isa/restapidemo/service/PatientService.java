package com.isa.restapidemo.service;

import com.isa.restapidemo.dao.CitizenDaoBean;
import com.isa.restapidemo.dto.CitizenDto;
import com.isa.restapidemo.dto.PatientDto;
import com.isa.restapidemo.model.Citizen;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequestScoped
public class PatientService {

    @Inject
    private CitizenDaoBean citizenDaoBean;

    private Citizen providePatient(PatientDto patientDto) {
        Citizen patient = new Citizen();
        patient.setAddress(patientDto.getAddress());
        patient.setBirthdate(patientDto.getBirthdate());
        patient.setCitizenId(patientDto.getCitizenId());
        patient.setDoctor(patientDto.getDoctor());
        patient.setIsDoctor(patientDto.getIsDoctor());
        patient.setGender(patientDto.getGender());
        patient.setName(patientDto.getName());
        patient.setSurname(patientDto.getSurname());
        patient.setPesel(patientDto.getPesel());
        return patient;
    }

    private PatientDto providePatientDto(Citizen patient) {
        PatientDto patientDto = new PatientDto();
        patientDto.setAddress(patient.getAddress());
        patientDto.setBirthdate(patient.getBirthdate());
        patientDto.setCitizenId(patient.getCitizenId());
        patientDto.setDoctor(patient.getDoctor());
        patientDto.setIsDoctor(patient.getIsDoctor());
        patientDto.setGender(patient.getGender());
        patientDto.setName(patient.getName());
        patientDto.setSurname(patient.getSurname());
        patientDto.setPesel(patient.getPesel());
        return patientDto;
    }

    @Transactional
    public PatientDto addPatient(PatientDto patientDto){
        Citizen patient = providePatient(patientDto);
        citizenDaoBean.save(patient);
        updatePatientsForDoctor(patient.getDoctor().getCitizenId(), patient.getPesel());
        return providePatientDto(patient);
    }

    @Transactional
    public PatientDto getPatientById(Integer patientId){
        Citizen patient = citizenDaoBean.getById(patientId);
        return providePatientDto(patient);
    }

    @Transactional
    public PatientDto updatePatient(Integer patientId, PatientDto patientDto){
        Citizen patient = citizenDaoBean.getById(patientId);
        Citizen updatePatient = providePatient(patientDto);
        patient.setAddress(updatePatient.getAddress());
        patient.setBirthdate(updatePatient.getBirthdate());
        patient.setDoctor(updatePatient.getDoctor());
        patient.setGender(updatePatient.getGender());
        patient.setName(updatePatient.getName());
        patient.setSurname(updatePatient.getSurname());
        patient.setPesel(updatePatient.getPesel());
        citizenDaoBean.update(patient);
        return providePatientDto(patient);
    }

    public void updatePatientsForDoctor(Integer doctorId, String patientPesel){
        Citizen doctor = citizenDaoBean.getById(doctorId);
        Set<Citizen> patients = doctor.getPatients();
        patients.add(citizenDaoBean.getByPesel(patientPesel).get());
        doctor.setPatients(patients);
        citizenDaoBean.update(doctor);

    }

    @Transactional
    public boolean removePatient(Integer patientId) {
        Citizen patient = citizenDaoBean.getById(patientId);
        if (patient == null) {
            return false;
        } else {
            citizenDaoBean.remove(patient);
            return true;
        }
    }

    @Transactional
    public List<PatientDto> getAllPatients(){
        List<Citizen> patients = citizenDaoBean.getPatients();
        return patients.stream()
                .map(this::providePatientDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public PatientDto getPatientByPesel(String patientPesel){
        Citizen patient = citizenDaoBean.getByPesel(patientPesel).get();
        return providePatientDto(patient);
    }

    @Transactional
    public List<PatientDto> getPatientBySurname(String patientSurname){
        List<Citizen> patients = citizenDaoBean.getBySurname(patientSurname);
        return patients.stream()
                .map(this::providePatientDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PatientDto> getPatientByCity(String patientCity){
        List<Citizen> patients = citizenDaoBean.getByCity(patientCity);
        return patients.stream()
                .map(this::providePatientDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PatientDto> getPatientByProvince(String patientProvince){
        List<Citizen> patients = citizenDaoBean.getByProvince(patientProvince);
        return patients.stream()
                .map(this::providePatientDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public List<PatientDto> getPatientByPostCode(String patientPostCode){
        List<Citizen> patients = citizenDaoBean.getBySurname(patientPostCode);
        return patients.stream()
                .map(this::providePatientDto)
                .collect(Collectors.toList());
    }


}
