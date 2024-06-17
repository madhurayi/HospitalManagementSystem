package com.example.hospitalmanagementsystem.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Patient extends BaseModel {

    @Column(nullable = false)
    private String name;

    private String Gender;

    private String age;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String address;

}
