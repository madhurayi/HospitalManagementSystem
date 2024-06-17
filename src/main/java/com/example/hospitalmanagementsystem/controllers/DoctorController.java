package com.example.hospitalmanagementsystem.controllers;

import com.example.hospitalmanagementsystem.models.Doctor;
import com.example.hospitalmanagementsystem.models.Patient;
import com.example.hospitalmanagementsystem.services.DoctorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/doctors")
public class DoctorController {

    private DoctorService doctorService;
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping
    public List<Doctor> getAllDoctors() {
        return doctorService.getAllDoctors();
    }

    @GetMapping("/{id}")
    public Doctor getDoctorById(@PathVariable long id) {
        return doctorService.getDoctorById(id);
    }

    @PostMapping
    public Doctor addDoctor(@RequestBody Doctor doctor) {
        return doctorService.createDoctor(doctor);
    }

    @PatchMapping("/{id}")
    public Doctor updateDoctor(@PathVariable long id, @RequestBody Doctor doctor) {
        return doctorService.updateDoctorById(id, doctor);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteDoctor(@PathVariable long id) {
        return doctorService.deleteDoctorById(id);
    }
}

