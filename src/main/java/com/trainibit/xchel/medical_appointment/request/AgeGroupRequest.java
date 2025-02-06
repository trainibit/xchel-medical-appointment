package com.trainibit.xchel.medical_appointment.request;

import jakarta.annotation.Nonnull;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Setter
@Getter
public class AgeGroupRequest {
    @NotBlank
    private String description;
    @NotNull
    private Boolean active;
}
