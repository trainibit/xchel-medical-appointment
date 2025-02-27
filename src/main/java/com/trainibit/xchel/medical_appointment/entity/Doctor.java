package com.trainibit.xchel.medical_appointment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@Entity(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid")
    private UUID uuid;

    @Column(name = "created_date")
    @CreationTimestamp
    private Timestamp createdDate;


    @Column(name = "updated_date")
    @UpdateTimestamp
    private Timestamp updatedDate;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "speciality_id")
    private Speciality speciality;

    @Column(name ="state")
    private Boolean state;

    @Column(name = "license")
    private String license;

}
