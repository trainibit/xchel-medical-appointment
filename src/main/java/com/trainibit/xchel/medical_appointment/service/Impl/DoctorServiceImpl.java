package com.trainibit.xchel.medical_appointment.service.Impl;

import com.trainibit.xchel.medical_appointment.entity.Doctor;
import com.trainibit.xchel.medical_appointment.mapper.DoctorMapper;
import com.trainibit.xchel.medical_appointment.repository.DoctorRepository;
import com.trainibit.xchel.medical_appointment.repository.SpecialityRepository;
import com.trainibit.xchel.medical_appointment.request.DoctorRequest;
import com.trainibit.xchel.medical_appointment.response.DoctorResponse;
import com.trainibit.xchel.medical_appointment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private DoctorMapper doctorMapper;

    @Autowired
    private SpecialityRepository specialityRepository;

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
        doctor.setSpeciality(
                specialityRepository.findByUuid(UUID.fromString(doctorRequest.getSpecialtyUuid()))
        );
        return doctorMapper.entityToResponse(doctorRepository.save(doctor));
    }

    @Override
    public DoctorResponse update(UUID uuid, DoctorRequest doctorRequest) {
        Doctor existentUser = doctorRepository.findByUuid(uuid);
        existentUser.setLicense(
                doctorRequest.getLicense() != null ? doctorRequest.getLicense() : existentUser.getLicense());

        existentUser.setState(
                doctorRequest.getState() != null ? doctorRequest.getState() : existentUser.getState()
        );

        existentUser.setSpeciality(
                doctorRequest.getSpecialtyUuid() != null
                        ? specialityRepository.getSpecialityByUuid(UUID.fromString(doctorRequest.getSpecialtyUuid()))
                        : existentUser.getSpeciality());


        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        existentUser.setUpdatedDate(currentTimeStamp);

        return doctorMapper.entityToResponse(doctorRepository.save(existentUser));
    }

    @Override
    public DoctorResponse delete(UUID uuid) {
        Doctor deleteUser = doctorRepository.findByUuid(uuid);
        doctorRepository.delete(deleteUser);
        return doctorMapper.entityToResponse(deleteUser);
    }
}