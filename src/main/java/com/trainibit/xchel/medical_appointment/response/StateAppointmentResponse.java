package com.trainibit.xchel.medical_appointment.response;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.UUID;


@Setter
@Getter
public class StateAppointmentResponse {
    private UUID uuid;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String description;
    private Boolean state;
}
