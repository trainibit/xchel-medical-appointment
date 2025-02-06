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
@Entity(name = "age_group")
public class AgeGroup {
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
    @Column(name="state")
    private Boolean state;
}
