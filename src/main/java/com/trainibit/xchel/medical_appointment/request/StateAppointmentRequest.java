package com.trainibit.xchel.medical_appointment.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StateAppointmentRequest {
    private String description;
    private boolean state;

}
