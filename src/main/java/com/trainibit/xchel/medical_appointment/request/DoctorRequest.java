package com.trainibit.xchel.medical_appointment.request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DoctorRequest {
    private String license;
    public Boolean state;
}
