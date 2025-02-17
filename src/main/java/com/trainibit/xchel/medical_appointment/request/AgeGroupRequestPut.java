package com.trainibit.xchel.medical_appointment.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgeGroupRequestPut {
    @NotBlank
    private String description;
    @NotNull
    private Boolean state;
}
