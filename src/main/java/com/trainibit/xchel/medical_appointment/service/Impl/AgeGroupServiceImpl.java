package com.trainibit.xchel.medical_appointment.service.Impl;

import com.trainibit.xchel.medical_appointment.entity.AgeGroup;
import com.trainibit.xchel.medical_appointment.mapper.AgeGroupMapper;
import com.trainibit.xchel.medical_appointment.repository.AgeGroupRepository;
import com.trainibit.xchel.medical_appointment.request.AgeGroupRequest;
import com.trainibit.xchel.medical_appointment.response.AgeGroupResponse;
import com.trainibit.xchel.medical_appointment.service.AgeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
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
        ageGroup.setUuid(UUID.randomUUID());
        AgeGroup savedAgeGroup=ageGroupRepository.save(ageGroup);

        return ageGroupMapper.entityToResponse(savedAgeGroup);
    }

    @Override
    public AgeGroupResponse update(UUID uuid, AgeGroupRequest ageGroupRequest) {
        AgeGroup existentUser = ageGroupRepository.findByUuid(uuid);

        existentUser.setDescription(
                ageGroupRequest.getDescription() != null ? ageGroupRequest.getDescription() : existentUser.getDescription());
        existentUser.setState(
                ageGroupRequest.getState() != null ? ageGroupRequest.getState() : existentUser.getState());

        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        existentUser.setUpdatedDate(currentTimeStamp);

        return ageGroupMapper.entityToResponse(ageGroupRepository.save(existentUser));
    }

    @Override
    public AgeGroupResponse delete(UUID uuid) {
        AgeGroup userToDelete = ageGroupRepository.findByUuid(uuid);
        ageGroupRepository.delete(userToDelete);
        return ageGroupMapper.entityToResponse(userToDelete);
    }


}
