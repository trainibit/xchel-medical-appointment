package com.trainibit.xchel.medical_appointment.service.Impl;

import com.trainibit.xchel.medical_appointment.entity.Doctor;
import com.trainibit.xchel.medical_appointment.mapper.DoctorMapper;
import com.trainibit.xchel.medical_appointment.repository.DoctorRepository;
import com.trainibit.xchel.medical_appointment.request.DoctorRequest;
import com.trainibit.xchel.medical_appointment.response.DoctorResponse;
import com.trainibit.xchel.medical_appointment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorMapper doctorMapper;

    @Override
    public List<DoctorResponse> findAll() {
        return doctorMapper.entitylistToResponseList(doctorRepository.findAll());
    }

    @Override
    public DoctorResponse findByUuid(UUID uuid) {
        return doctorMapper.entityToResponse(doctorRepository.findByUuid(uuid));
    }

    @Override
    public DoctorResponse save(DoctorRequest doctorRequest) {
        Doctor doctor = doctorMapper.requestToEntity(doctorRequest);
        doctor.setUuid(UUID.randomUUID());
        return doctorMapper.entityToResponse(doctorRepository.save(doctor));
    }
}
