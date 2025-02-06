package com.trainibit.xchel.medical_appointment.service;

import com.trainibit.xchel.medical_appointment.entity.MedicalAppointment;
import com.trainibit.xchel.medical_appointment.request.MedicalAppointmentRequest;
import com.trainibit.xchel.medical_appointment.response.MedicalAppointmentResponse;

import java.util.List;
import java.util.UUID;

public interface MedicalAppointmentService {
    List<MedicalAppointmentResponse> findAll();
    MedicalAppointmentResponse findByUuid(UUID uuid);
    MedicalAppointmentResponse save(MedicalAppointmentRequest medicalAppointmentRequest);
}
