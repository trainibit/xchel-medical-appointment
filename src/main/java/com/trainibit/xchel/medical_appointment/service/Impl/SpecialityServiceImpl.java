package com.trainibit.xchel.medical_appointment.service.Impl;

import com.trainibit.xchel.medical_appointment.entity.Speciality;
import com.trainibit.xchel.medical_appointment.mapper.SpecialityMapper;
import com.trainibit.xchel.medical_appointment.repository.SpecialityRepository;
import com.trainibit.xchel.medical_appointment.request.SpecialityRequest;
import com.trainibit.xchel.medical_appointment.response.SpecialityResponse;
import com.trainibit.xchel.medical_appointment.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class SpecialityServiceImpl implements SpecialityService {

    @Autowired
    private SpecialityMapper specialityMapper;

    @Autowired
    private SpecialityRepository specialityRepository;

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
        Speciality savedSpeciality = specialityRepository.save(speciality);
        return specialityMapper.entityToResponse(savedSpeciality);
    }
}
