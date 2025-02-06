package com.trainibit.xchel.medical_appointment.service;

import com.trainibit.xchel.medical_appointment.entity.Speciality;
import com.trainibit.xchel.medical_appointment.request.SpecialityRequest;
import com.trainibit.xchel.medical_appointment.response.SpecialityResponse;

import java.util.List;
import java.util.UUID;

public interface SpecialityService {
    List<SpecialityResponse> findAll();
    SpecialityResponse findByUuid(UUID uuid);
    SpecialityResponse save(SpecialityRequest specialityRequest);
}
