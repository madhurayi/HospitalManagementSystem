package com.example.hospitalmanagementsystem.services;

import com.example.hospitalmanagementsystem.models.Patient;
import com.example.hospitalmanagementsystem.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public List<Patient> getAllPatients(){
        try{
            return patientRepository.findAll();

        }catch (Exception e) {
            System.out.println("Error in getAllPatients" + e.getMessage());
            return null;
        }
    }

    public Patient createPatient(Patient patient) {
        return patientRepository.save(patient);
    }

    public Patient getPatientById(long id) {
        Patient patient = patientRepository.findById(id).get();
        if (patient == null) {
            return null;
        }
        return patient;
    }

    public Patient updatePatientById(long id, Patient patient) {
        Patient patient1 = patientRepository.findById(id).get();
        if (patient1 != null) {
            if(patient.getAddress()!=null){
                patient1.setAddress(patient.getAddress());
            }
            if(patient.getAge()!=null){
                patient1.setAge(patient.getAge());
            }
            if(patient.getName()!=null){
                patient1.setName(patient.getName());
            }
            if(patient.getGender()!=null){
                patient1.setGender(patient.getGender());
            }
            if(patient.getPhoneNumber()!=null){
                patient1.setPhoneNumber(patient.getPhoneNumber());
            }
            patientRepository.save(patient1);

        }
        return patient1;
    }
    public boolean deletePatientById(long id) {
        Patient patient = patientRepository.findById(id).get();
        if (patient != null) {
            patientRepository.delete(patient);
        }
        return true;
    }



}
