package com.trainibit.xchel.medical_appointment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity (name = "medical_appointment")
@Getter
@Setter
public class MedicalAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid", insertable = false)
    private UUID uuid;
    @Column(name="created_date",insertable = false,updatable = false )
    private Timestamp createdDate;
    @Column(name = "updated_date",insertable = false)
    private Timestamp updatedDate;
    @Column(name="scheduled_for",insertable = false)
    private Timestamp scheduledFor;
    @Column(name="rason",insertable = false)
    private String rason;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "stateAppointment", nullable = false)
    private StateAppointment stateAppointment;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "doctor", nullable = false)
    private Doctor doctor;
    @Column(name ="asisten",insertable = false)
    private String asisten;
    @Column(name ="state",insertable = false)
    private Boolean state;

}
