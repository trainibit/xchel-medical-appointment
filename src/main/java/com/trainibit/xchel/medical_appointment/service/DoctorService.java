package com.trainibit.xchel.medical_appointment.service;

import com.trainibit.xchel.medical_appointment.entity.Doctor;
import com.trainibit.xchel.medical_appointment.request.DoctorRequest;
import com.trainibit.xchel.medical_appointment.response.DoctorResponse;

import java.util.List;
import java.util.UUID;

public interface DoctorService {
    List<DoctorResponse> findAll();
    DoctorResponse findByUuid(UUID uuid);
    DoctorResponse save(DoctorRequest doctorRequest);
    DoctorResponse update(UUID uuid,DoctorRequest doctorRequest);
    DoctorResponse delete(UUID uuid);
    DoctorResponse createDoctor(String specialtyUuid,String license,Boolean state);
    DoctorResponse updateDoctor(UUID uuid,String specialtyUuid,String license,Boolean state);
    DoctorResponse deleteDoctor(UUID uuid);
}
