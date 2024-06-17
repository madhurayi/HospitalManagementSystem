package com.example.hospitalmanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Doctor extends BaseModel{

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String qualification;

    @Column(nullable = false)
    private String speciality;

}
