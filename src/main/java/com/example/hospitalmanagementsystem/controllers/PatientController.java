package com.example.hospitalmanagementsystem.controllers;

import com.example.hospitalmanagementsystem.models.Patient;
import com.example.hospitalmanagementsystem.services.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
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
    public Page<Patient> getAllPatients(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "2") int size) {

        return patientService.getAllPatients(page,size);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPatientById(@PathVariable long id) {
        return ResponseEntity.ok(patientService.getPatientById(id));
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
