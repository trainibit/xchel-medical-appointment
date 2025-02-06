package com.trainibit.xchel.medical_appointment.mapper;

import com.trainibit.xchel.medical_appointment.entity.StateAppointment;
import com.trainibit.xchel.medical_appointment.request.StateAppointmentRequest;
import com.trainibit.xchel.medical_appointment.response.StateAppointmentResponse;

import java.util.List;

public interface StateAppointmentMapper {
    StateAppointmentResponse entityToResponse(StateAppointment stateAppointment);
    List<StateAppointmentResponse> entityListToResponseList(List<StateAppointment> stateAppointmentList);
    StateAppointment requestToEntity(StateAppointmentRequest stateAppointmentRequest);
}
