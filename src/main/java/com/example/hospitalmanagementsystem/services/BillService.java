package com.example.hospitalmanagementsystem.services;

import com.example.hospitalmanagementsystem.models.Bill;
import com.example.hospitalmanagementsystem.models.Doctor;
import com.example.hospitalmanagementsystem.models.Patient;
import com.example.hospitalmanagementsystem.repositories.BillRepository;
import com.example.hospitalmanagementsystem.repositories.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BillService {

    private BillRepository billRepository;
    private PatientRepository patientRepository;

    public BillService(BillRepository billRepository, PatientRepository patientRepository) {
        this.billRepository = billRepository;
        this.patientRepository = patientRepository;
    }

    public List<Bill> getAllBills() {
        return billRepository.findAll();
    }

    public Optional<Bill> getBillById(long id) {
        return billRepository.findById(id);
    }

    public Bill createBill(Bill bill) {
        Long ptnId= bill.getPatient().getId();
        Patient patient= patientRepository.findById(ptnId).get();
        bill.setPatient(patient);
        bill.setStatus("PENDING");
        return billRepository.save(bill);
    }
    public Bill updateBill(long id, Bill bill) {
        Bill billToUpdate = billRepository.findById(id).get();
        if(billToUpdate != null) {
            if(bill.getDate() != null) {
                billToUpdate.setDate(bill.getDate());
            }
            if(bill.getAmount()>=0){
                billToUpdate.setAmount(bill.getAmount());
            }
            if(bill.getPatient()!=null){
                Long ptnId= bill.getPatient().getId();
                Patient patient= patientRepository.findById(ptnId).get();
                billToUpdate.setPatient(patient);
            }if(bill.getStatus()!=null){
                billToUpdate.setStatus(bill.getStatus());
            }
            return billRepository.save(billToUpdate);

        }
        return null;
    }
    public Boolean deleteBill(long id) {
        billRepository.deleteById(id);
        return true;
    }

}

