package com.trainibit.xchel.medical_appointment.mapper;

import com.trainibit.xchel.medical_appointment.entity.AgeGroup;
import com.trainibit.xchel.medical_appointment.request.AgeGroupRequest;
import com.trainibit.xchel.medical_appointment.response.AgeGroupResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AgeGroupMapper {
    AgeGroupResponse entityToResponse(AgeGroup ageGroup);
    List<AgeGroupResponse> entityListToResponseList (List<AgeGroup> userList);
    AgeGroup requestToEntity(AgeGroupRequest ageGroupRequest);

}
