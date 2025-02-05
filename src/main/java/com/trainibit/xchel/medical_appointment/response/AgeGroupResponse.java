package com.trainibit.xchel.medical_appointment.response;

import java.sql.Timestamp;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AgeGroupResponse {
    private UUID uuid;
    private Timestamp createdDate;
    private Timestamp updatedDate;
    private String description;
    private Boolean state;
}
