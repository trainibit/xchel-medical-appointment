package com.trainibit.xchel.medical_appointment.service.Impl;

import com.trainibit.xchel.medical_appointment.entity.AgeGroup;
import com.trainibit.xchel.medical_appointment.mapper.AgeGroupMapper;
import com.trainibit.xchel.medical_appointment.repository.AgeGroupRepository;
import com.trainibit.xchel.medical_appointment.request.AgeGroupRequest;
import com.trainibit.xchel.medical_appointment.response.AgeGroupResponse;
import com.trainibit.xchel.medical_appointment.service.AgeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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

    @Autowired
    private JdbcTemplate jdbcTemplate; // Se mantiene la inyección con @Autowired


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

    @Override
    public AgeGroupResponse updateAgeGroup(UUID uuid, String description, Boolean state) {
        String sql = "CALL update_age_group(CAST(? AS UUID), ?, ?)";
        jdbcTemplate.update(sql, uuid.toString(), description, state);

        AgeGroupResponse response = new AgeGroupResponse();
        response.setUuid(uuid);
        response.setDescription(description);
        response.setState(state);

        return response;
    }


    @Override
    public AgeGroupResponse createAgeGroup(String description, Boolean state) {
        String sql = "CALL create_age_group(?, ?)";
        jdbcTemplate.update(sql, description, state);

        AgeGroupResponse response = new AgeGroupResponse();
        response.setDescription(description);
        response.setState(state);
        return response;
    }


    @Override
    public AgeGroupResponse deleteAgeGroup(UUID uuid) {
        String sql = "CALL delete_age_group(CAST(? AS UUID))";
        jdbcTemplate.update(sql, uuid);
        AgeGroupResponse response = new AgeGroupResponse();
        return response;
    }

}
