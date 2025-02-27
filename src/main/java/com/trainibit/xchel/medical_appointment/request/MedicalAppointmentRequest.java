package com.trainibit.xchel.medical_appointment.request;

import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Setter
@Getter
public class MedicalAppointmentRequest {
    private Timestamp scheduledFor;
    private String reason;
    private String stateAppointmentUuid;
    private String doctorUuid;
    private String assistant;
    private Boolean state;
}
