package com.trainibit.xchel.medical_appointment.request;

import jakarta.annotation.Nonnull;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import org.antlr.v4.runtime.misc.NotNull;

@Setter
@Getter
public class AgeGroupRequest {
    @Nonnull
    private String description;
    @Nonnull
    private Boolean active;
}
