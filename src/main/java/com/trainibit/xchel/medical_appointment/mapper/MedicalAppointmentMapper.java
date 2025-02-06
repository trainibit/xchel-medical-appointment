package com.trainibit.xchel.medical_appointment.mapper;

import com.trainibit.xchel.medical_appointment.entity.MedicalAppointment;
import com.trainibit.xchel.medical_appointment.request.MedicalAppointmentRequest;
import com.trainibit.xchel.medical_appointment.response.MedicalAppointmentResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicalAppointmentMapper {
    MedicalAppointmentResponse entityToResponse(MedicalAppointment medicalAppointment);
    List<MedicalAppointmentResponse> entityListToResponseList(List<MedicalAppointment> medicalAppointmentList);
    MedicalAppointment requestToEntity(MedicalAppointmentRequest medicalAppointmentRequest);
}
