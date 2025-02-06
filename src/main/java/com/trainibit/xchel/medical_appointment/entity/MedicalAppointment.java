package com.trainibit.xchel.medical_appointment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Entity(name = "medical_appointment")
@Getter
@Setter
public class MedicalAppointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uuid", insertable = false)
    private UUID uuid;
    @Column(name = "created_date", insertable = false, updatable = false)
    private Timestamp createdDate;
    @Column(name = "updated_date", insertable = false)
    private Timestamp updatedDate;
    @Column(name = "scheduled_for", insertable = false)
    private Timestamp scheduledFor;
    @Column(name = "reason", insertable = false)
    private String reason;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "state_appointment_id", nullable = false)
    private StateAppointment stateAppointment;
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;
    @Column(name = "assistant", insertable = false)
    private String assistant;
    @Column(name = "state", insertable = false)
    private Boolean state;

}
