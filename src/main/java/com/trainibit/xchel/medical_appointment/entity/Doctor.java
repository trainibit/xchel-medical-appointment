package com.trainibit.xchel.medical_appointment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@Entity(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid", nullable = false)
    private UUID uuid;

    @Column(name = "created_date", insertable = false, updatable = false)
    private Timestamp createdDate;
    @Column(name = "updated_date",insertable = false)
    private Timestamp updatedDate;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "speciality_id", nullable = false)
    private Speciality speciality;
    @Column(name ="state", insertable = false)
    private Boolean state;
    @Column(name = "license",insertable = false)
    private String license;

}
