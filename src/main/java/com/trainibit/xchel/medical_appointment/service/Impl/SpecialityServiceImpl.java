package com.trainibit.xchel.medical_appointment.service.Impl;

import com.trainibit.xchel.medical_appointment.entity.AgeGroup;
import com.trainibit.xchel.medical_appointment.entity.Speciality;
import com.trainibit.xchel.medical_appointment.mapper.SpecialityMapper;
import com.trainibit.xchel.medical_appointment.repository.AgeGroupRepository;
import com.trainibit.xchel.medical_appointment.repository.SpecialityRepository;
import com.trainibit.xchel.medical_appointment.request.SpecialityRequest;
import com.trainibit.xchel.medical_appointment.response.SpecialityResponse;
import com.trainibit.xchel.medical_appointment.service.SpecialityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityMapper specialityMapper;

    @Autowired
    private SpecialityRepository specialityRepository;

    @Autowired
    private AgeGroupRepository ageGroupRepository;

    @Override
    public List<SpecialityResponse> findAll() {
        return specialityMapper.entityListToResponseList(specialityRepository.findAll());
    }

    @Override
    public SpecialityResponse findByUuid(UUID uuid) {
        return specialityMapper.entityToResponse(specialityRepository.findByUuid(uuid));
    }
    @Override
    public SpecialityResponse save(SpecialityRequest specialityRequest) {
        Speciality speciality = specialityMapper.requestToEntity(specialityRequest);
        speciality.setUuid(UUID.randomUUID());

        speciality.setAgeGroup(
                ageGroupRepository.findByUuid(UUID.fromString(specialityRequest.getAgeGroupUuid()))
        );
        Speciality savedSpeciality = specialityRepository.save(speciality);
        return specialityMapper.entityToResponse(savedSpeciality);
    }

    @Override
    public SpecialityResponse update(UUID uuid, SpecialityRequest specialityRequest) {

        Speciality existentUser = specialityRepository.findByUuid(uuid);

        existentUser.setDescription(
                specialityRequest.getDescription() != null ? specialityRequest.getDescription() : existentUser.getDescription());
        existentUser.setSex(
                specialityRequest.getSex() != null ? specialityRequest.getSex() : existentUser.getSex());

        existentUser.setState(
                specialityRequest.getState() != null ? specialityRequest.getState() : existentUser.getState());

        existentUser.setAgeGroup(
                specialityRequest.getAgeGroupUuid() != null
                        ? ageGroupRepository.getAgeGroupsByUuid(UUID.fromString(specialityRequest.getAgeGroupUuid()))
                        : existentUser.getAgeGroup());


        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        existentUser.setUpdatedDate(currentTimeStamp);

        return specialityMapper.entityToResponse(specialityRepository.save(existentUser));
    }

    @Override
    public SpecialityResponse delete(UUID uuid) {
        Speciality userToDelete = specialityRepository.findByUuid(uuid);
        specialityRepository.delete(userToDelete);
        return specialityMapper.entityToResponse(userToDelete);
    }
}
