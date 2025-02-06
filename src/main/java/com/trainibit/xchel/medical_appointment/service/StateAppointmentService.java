package com.trainibit.xchel.medical_appointment.service;

import com.trainibit.xchel.medical_appointment.request.StateAppointmentRequest;
import com.trainibit.xchel.medical_appointment.response.StateAppointmentResponse;

import java.util.List;
import java.util.UUID;


public interface StateAppointmentService {
    List<StateAppointmentResponse> findAll();
    StateAppointmentResponse findByUUID(UUID uuid);
    StateAppointmentResponse save(StateAppointmentRequest stateAppointmentRequest);
}
