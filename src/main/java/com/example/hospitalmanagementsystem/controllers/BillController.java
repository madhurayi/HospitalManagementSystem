package com.example.hospitalmanagementsystem.controllers;

import com.example.hospitalmanagementsystem.models.Bill;
import com.example.hospitalmanagementsystem.services.BillService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {
    private final BillService billService;
    public BillController(BillService billService) {
        this.billService = billService;
    }
    @GetMapping
    public List<Bill> getAllBills() {
        return billService.getAllBills();
    }

    @GetMapping("/{id}")
    public Optional<Bill> getBillById(@PathVariable long id) {
        return billService.getBillById(id);
    }
    @PostMapping
    public Bill createBill(@RequestBody Bill bill) {
        return billService.createBill(bill);
    }
    @PatchMapping("/{id}")
    public Bill updateBill(@PathVariable long id, @RequestBody Bill bill) {
        return billService.updateBill(id,bill);
    }
    @DeleteMapping("/{id}")
    public Boolean deleteBill(@PathVariable long id) {
        billService.deleteBill(id);
        return true;
    }

}
