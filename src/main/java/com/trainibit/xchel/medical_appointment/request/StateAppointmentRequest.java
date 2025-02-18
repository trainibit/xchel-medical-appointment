package com.trainibit.xchel.medical_appointment.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StateAppointmentRequest {
    @NotBlank
    private String description;
    @NotNull
    private Boolean state;
}
