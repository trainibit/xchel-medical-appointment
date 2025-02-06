package com.trainibit.xchel.medical_appointment.mapper;

import com.trainibit.xchel.medical_appointment.entity.Speciality;
import com.trainibit.xchel.medical_appointment.request.SpecialityRequest;
import com.trainibit.xchel.medical_appointment.response.SpecialityResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SpecialityMapper {
    SpecialityResponse entityToResponse(Speciality speciality);
    List<SpecialityResponse> entityListToResponseList(List<Speciality> specialityList);
    Speciality requestToEntity(SpecialityRequest specialityRequest);
}
