package com.trainibit.xchel.medical_appointment.mapper;

import com.trainibit.xchel.medical_appointment.entity.Doctor;
import com.trainibit.xchel.medical_appointment.request.DoctorRequest;
import com.trainibit.xchel.medical_appointment.response.DoctorResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DoctorMapper {
    DoctorResponse entityToResponse(Doctor doctor);
    List<DoctorResponse> entitylistToResponseList(List<Doctor> doctorList);
    Doctor requestToEntity(DoctorRequest doctorRequest);

}
