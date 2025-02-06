package com.trainibit.xchel.medical_appointment.service.Impl;

import com.trainibit.xchel.medical_appointment.entity.AgeGroup;
import com.trainibit.xchel.medical_appointment.mapper.AgeGroupMapper;
import com.trainibit.xchel.medical_appointment.repository.AgeGroupRepository;
import com.trainibit.xchel.medical_appointment.request.AgeGroupRequest;
import com.trainibit.xchel.medical_appointment.response.AgeGroupResponse;
import com.trainibit.xchel.medical_appointment.service.AgeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class AgeGroupServiceImpl implements AgeGroupService {

    @Autowired
    private AgeGroupRepository ageGroupRepository;

    @Autowired
    private AgeGroupMapper ageGroupMapper;

    @Override
    public List<AgeGroupResponse> findAll() {
        return ageGroupMapper.entityListToResponseList(ageGroupRepository.findAll()) ;
    }

    @Override
    public AgeGroupResponse findByUuid(UUID uuid) {
        return ageGroupMapper.entityToResponse(ageGroupRepository.findByUuid(uuid));
    }

    @Override
    public AgeGroupResponse save(AgeGroupRequest ageGroupRequest) {
        AgeGroup ageGroup=ageGroupMapper.requestToEntity(ageGroupRequest);
        AgeGroup savedAgeGroup=ageGroupRepository.save(ageGroup);
        ageGroup.setUuid(UUID.randomUUID());
        return ageGroupMapper.entityToResponse(savedAgeGroup);
    }
}
