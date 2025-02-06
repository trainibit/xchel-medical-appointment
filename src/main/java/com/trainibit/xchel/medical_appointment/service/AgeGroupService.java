package com.trainibit.xchel.medical_appointment.service;

import com.trainibit.xchel.medical_appointment.entity.AgeGroup;
import com.trainibit.xchel.medical_appointment.request.AgeGroupRequest;
import com.trainibit.xchel.medical_appointment.response.AgeGroupResponse;

import java.util.List;
import java.util.UUID;

public interface AgeGroupService {
    List<AgeGroupResponse> findAll();
    AgeGroupResponse findByUuid(UUID uuid);
    AgeGroupResponse save(AgeGroupRequest ageGroupRequest);
}
