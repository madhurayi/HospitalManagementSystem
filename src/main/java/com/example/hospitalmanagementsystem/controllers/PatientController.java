package com.example.hospitalmanagementsystem.controllers;

import com.example.hospitalmanagementsystem.models.Patient;
import com.example.hospitalmanagementsystem.services.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/patients")
public class PatientController {

    private final PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @GetMapping
    public List<Patient> getAllPatients() {
        return patientService.getAllPatients();
    }

    @GetMapping("/{id}")
    public Patient getPatientById(@PathVariable long id) {
        return patientService.getPatientById(id);
    }

    @PostMapping
    public Patient addPatient(@RequestBody Patient patient) {
        return patientService.createPatient(patient);
    }

    @PatchMapping("/{id}")
    public Patient updatePatient(@PathVariable long id, @RequestBody Patient patient) {
        return patientService.updatePatientById(id, patient);
    }

    @DeleteMapping("/{id}")
    public Boolean deletePatient(@PathVariable long id) {
       return patientService.deletePatientById(id);
    }
}
