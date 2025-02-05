package com.trainibit.xchel.medical_appointment.request;


import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SpecialityRequest {
    private String description;
    private Boolean sex;
    private Boolean state;
}
