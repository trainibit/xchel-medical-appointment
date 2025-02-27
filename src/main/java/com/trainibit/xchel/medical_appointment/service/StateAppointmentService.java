package com.trainibit.xchel.medical_appointment.service;

import com.trainibit.xchel.medical_appointment.request.StateAppointmentRequest;
import com.trainibit.xchel.medical_appointment.response.StateAppointmentResponse;

import java.util.List;
import java.util.UUID;


public interface StateAppointmentService {
    List<StateAppointmentResponse> findAll();
    StateAppointmentResponse findByUuid(UUID uuid);
    StateAppointmentResponse save(StateAppointmentRequest stateAppointmentRequest);
    StateAppointmentResponse update(UUID uuid,StateAppointmentRequest stateAppointmentRequest);
    StateAppointmentResponse delete(UUID uuid);
}
