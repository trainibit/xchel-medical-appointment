package com.trainibit.xchel.medical_appointment.request;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Setter
@Getter
public class AgeGroupRequest {
    @NonNull
    private String description;
    @NonNull
    private Boolean active;
}
