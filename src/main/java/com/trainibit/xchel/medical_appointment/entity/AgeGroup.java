package com.trainibit.xchel.medical_appointment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;

@Setter
@Getter
@Entity(name = "age_group")
public class AgeGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name ="uuid",insertable = false)
    private UUID uuid;
    @Column(name="created_date",insertable = false,updatable = false )
    private Timestamp createdDate;
    @Column(name = "updated_date",insertable = false)
    private Timestamp updatedDate;
    @Column(name="description",insertable = false,updatable = false )
    private String description;
    @Column(name="state",insertable = false)
    private Boolean state;
}
