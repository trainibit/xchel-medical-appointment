package com.trainibit.xchel.medical_appointment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@Entity(name ="speciality")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="uuid")
    private UUID uuid;

    @Column(name="created_date")
    @CreationTimestamp
    private Timestamp createdDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private Timestamp updatedDate;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "age_group_id", nullable = false)
    private AgeGroup ageGroup;

    @Column(name = "sex")
    private Boolean sex;

    @Column(name = "state")
    private Boolean state;
}
