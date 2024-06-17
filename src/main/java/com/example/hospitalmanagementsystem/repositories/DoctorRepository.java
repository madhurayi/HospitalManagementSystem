package com.example.hospitalmanagementsystem.repositories;

import com.example.hospitalmanagementsystem.models.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
