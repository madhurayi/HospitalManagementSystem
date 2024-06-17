package com.example.hospitalmanagementsystem.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.*;

import java.util.Date;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Bill extends BaseModel{

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String status;

    @ManyToOne(cascade = CascadeType.ALL)
    private Patient patient;

}
