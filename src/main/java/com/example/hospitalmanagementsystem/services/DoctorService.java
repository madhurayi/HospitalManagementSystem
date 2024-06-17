package com.example.hospitalmanagementsystem.services;

import com.example.hospitalmanagementsystem.models.Doctor;
import com.example.hospitalmanagementsystem.models.Patient;
import com.example.hospitalmanagementsystem.repositories.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    public List<Doctor> getAllDoctors(){
        try{
            return doctorRepository.findAll();

        }catch (Exception e) {
            System.out.println("Error in getAllDoctors" + e.getMessage());
            return null;
        }
    }

    public Doctor createDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    public Doctor getDoctorById(long id) {
        Doctor doctor = doctorRepository.findById(id).get();
        if (doctor == null) {
            return null;
        }
        return doctor;
    }

    public Doctor updateDoctorById(long id, Doctor doctor) {
        Doctor doctor1 = doctorRepository.findById(id).get();
        if (doctor1 != null) {

            if(doctor.getName()!=null){
                doctor1.setName(doctor.getName());
            }
            if(doctor.getQualification()!=null){
                doctor1.setQualification(doctor.getQualification());
            }
            if(doctor.getSpeciality()!=null){
                doctor1.setSpeciality(doctor.getSpeciality());
            }
            doctorRepository.save(doctor1);

        }
        return doctor1;
    }
    public boolean deleteDoctorById(long id) {
        Doctor doctor = doctorRepository.findById(id).get();
        if (doctor != null) {
            doctorRepository.delete(doctor);
        }
        return true;
    }
}
