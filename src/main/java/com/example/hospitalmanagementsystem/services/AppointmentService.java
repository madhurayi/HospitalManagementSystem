package com.example.hospitalmanagementsystem.services;

import com.example.hospitalmanagementsystem.models.Appointment;
import com.example.hospitalmanagementsystem.models.Doctor;
import com.example.hospitalmanagementsystem.models.Patient;
import com.example.hospitalmanagementsystem.repositories.AppointmentRepository;
import com.example.hospitalmanagementsystem.repositories.DoctorRepository;
import com.example.hospitalmanagementsystem.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;
    public AppointmentService(AppointmentRepository appointmentRepository, DoctorRepository doctorRepository, PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public List<Appointment> getAllAppointments() {
        return appointmentRepository.findAll();
    }

    public Appointment createAppointment(Appointment appointment) {
        Long dctrId= appointment.getDoctor().getId();
        Long ptnId= appointment.getPatient().getId();
        Doctor doctor= doctorRepository.findById(dctrId).get();
        Patient patient= patientRepository.findById(ptnId).get();
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);
        return appointmentRepository.save(appointment);
    }
    public Appointment getAppointmentById(long id) {
        Appointment appointment = appointmentRepository.findById(id).get();
        return appointment;
    }
    public Appointment updateAppointment(long id, Appointment appointment) {
        Appointment appointment1 = appointmentRepository.findById(id).get();
        if(appointment1 != null) {
            if(appointment.getDoctor()!=null){
                Long dctrId= appointment.getDoctor().getId();
                Doctor doctor= doctorRepository.findById(dctrId).get();
                appointment1.setDoctor(doctor);
            }
            if(appointment.getPatient()!=null){
                Long ptnId= appointment.getPatient().getId();
                Patient patient= patientRepository.findById(ptnId).get();
                appointment1.setPatient(patient);
            }
            if(appointment.getAppointmentTime()!=null){
                appointment1.setAppointmentTime(appointment.getAppointmentTime());
            }
            Appointment ap= appointmentRepository.save(appointment1);
            return ap;
        }
        return null;
    }
    public Boolean deleteAppointment(long id) {
        Appointment appointment= appointmentRepository.findById(id).get();
        appointmentRepository.delete(appointment);
        return true;
    }
}
