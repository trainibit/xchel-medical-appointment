package com.trainibit.xchel.medical_appointment.service.Impl;

import com.trainibit.xchel.medical_appointment.entity.MedicalAppointment;
import com.trainibit.xchel.medical_appointment.mapper.MedicalAppointmentMapper;
import com.trainibit.xchel.medical_appointment.repository.MedicalAppointmentRepository;
import com.trainibit.xchel.medical_appointment.request.MedicalAppointmentRequest;
import com.trainibit.xchel.medical_appointment.response.MedicalAppointmentResponse;
import com.trainibit.xchel.medical_appointment.service.MedicalAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class MedicalAppontmentServiceImpl implements MedicalAppointmentService {

    @Autowired
    private MedicalAppointmentRepository medicalAppointmentRepository;

    @Autowired
    private MedicalAppointmentMapper medicalAppointmentMapper;

    @Override
    public List<MedicalAppointmentResponse> findAll() {
        return medicalAppointmentMapper.entityListToResponseList(medicalAppointmentRepository.findAll());
    }

    @Override
    public MedicalAppointmentResponse findByUuid(UUID uuid) {
        return medicalAppointmentMapper.entityToResponse(medicalAppointmentRepository.findByUuid(uuid));
    }

    @Override
    public MedicalAppointmentResponse save(MedicalAppointmentRequest medicalAppointmentRequest) {
        MedicalAppointment medicalAppointment = medicalAppointmentMapper.requestToEntity(medicalAppointmentRequest);
        medicalAppointment.setUuid(UUID.randomUUID());
        MedicalAppointment saveMedicalAppointment = medicalAppointmentRepository.save(medicalAppointment);
        return medicalAppointmentMapper.entityToResponse(medicalAppointment);
    }
}
