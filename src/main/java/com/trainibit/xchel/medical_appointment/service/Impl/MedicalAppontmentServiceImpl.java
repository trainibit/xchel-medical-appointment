package com.trainibit.xchel.medical_appointment.service.Impl;

import com.trainibit.xchel.medical_appointment.entity.MedicalAppointment;
import com.trainibit.xchel.medical_appointment.mapper.MedicalAppointmentMapper;
import com.trainibit.xchel.medical_appointment.repository.DoctorRepository;
import com.trainibit.xchel.medical_appointment.repository.MedicalAppointmentRepository;
import com.trainibit.xchel.medical_appointment.repository.StateAppointmentRepository;
import com.trainibit.xchel.medical_appointment.request.MedicalAppointmentRequest;
import com.trainibit.xchel.medical_appointment.response.DoctorResponse;
import com.trainibit.xchel.medical_appointment.response.MedicalAppointmentResponse;
import com.trainibit.xchel.medical_appointment.service.MedicalAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class MedicalAppontmentServiceImpl implements MedicalAppointmentService {

    @Autowired
    private MedicalAppointmentRepository medicalAppointmentRepository;

    @Autowired
    private MedicalAppointmentMapper medicalAppointmentMapper;


    @Autowired
    private StateAppointmentRepository stateAppointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private JdbcTemplate jdbcTemplate; // Se mantiene la inyección con @Autowired

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

        medicalAppointment.setStateAppointment(
                stateAppointmentRepository.findByUuid(UUID.fromString(medicalAppointmentRequest.getStateAppointmentUuid()))
        );
        medicalAppointment.setDoctor(
                doctorRepository.findByUuid(UUID.fromString(medicalAppointmentRequest.getDoctorUuid()))
        );

        MedicalAppointment saveMedicalAppointment = medicalAppointmentRepository.save(medicalAppointment);
        return medicalAppointmentMapper.entityToResponse(saveMedicalAppointment);
    }

    @Override
    public MedicalAppointmentResponse update(UUID uuid, MedicalAppointmentRequest medicalAppointmentRequest) {
        MedicalAppointment existentUser= medicalAppointmentRepository.findByUuid(uuid);

        existentUser.setScheduledFor(
                medicalAppointmentRequest.getScheduledFor() != null ? medicalAppointmentRequest.getScheduledFor() : existentUser.getScheduledFor());
        existentUser.setReason(
                medicalAppointmentRequest.getReason() != null ? medicalAppointmentRequest.getReason() : existentUser.getReason()
        );
        existentUser.setAssistant(
                medicalAppointmentRequest.getAssistant() != null ? medicalAppointmentRequest.getAssistant() : existentUser.getAssistant()
        );
        existentUser.setState(
                medicalAppointmentRequest.getState() != null ? medicalAppointmentRequest.getState() : existentUser.getState()
        );

        existentUser.setStateAppointment(
                medicalAppointmentRequest.getStateAppointmentUuid() != null
                        ? stateAppointmentRepository.getStateAppointmentByUuid(UUID.fromString(medicalAppointmentRequest.getStateAppointmentUuid()))
                        : existentUser.getStateAppointment()
        );

        existentUser.setDoctor(
                medicalAppointmentRequest.getDoctorUuid() != null
                        ? doctorRepository.getDoctorByUuid(UUID.fromString(medicalAppointmentRequest.getDoctorUuid()))
                        : existentUser.getDoctor()
        );





        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        existentUser.setUpdatedDate(currentTimeStamp);

        return medicalAppointmentMapper.entityToResponse(medicalAppointmentRepository.save(existentUser));
    }

    @Override
    public MedicalAppointmentResponse delete(UUID uuid) {
        MedicalAppointment medicalAppointment = medicalAppointmentRepository.findByUuid(uuid);
        medicalAppointmentRepository.delete(medicalAppointment);
        return medicalAppointmentMapper.entityToResponse(medicalAppointment);
    }

    @Override
    public MedicalAppointmentResponse createMedicalAppointment(Timestamp scheduledFor, String reason, String stateAppointmentUuid,String doctorUuid, String assistant, Boolean state) {
        String sql = "CALL create_medical_appointment(?,?,?::uuid,?::uuid,?,?)";
        jdbcTemplate.update(sql, scheduledFor, reason, stateAppointmentUuid, doctorUuid, assistant, state);
        MedicalAppointmentResponse response = new MedicalAppointmentResponse();
        response.setScheduledFor(scheduledFor);
        response.setReason(reason);
        response.setState_appointment_id(stateAppointmentUuid);
        response.setDoctor_id(doctorUuid);
        response.setAssistant(assistant);
        response.setState(state);
        return response;
    }

    @Override
    public MedicalAppointmentResponse updateMedicalAppointment(UUID uuid, Timestamp scheduledFor, String reason, String stateAppointmentUuid, String doctorUuid, String assistant, Boolean state) {
        return null;
    }

    @Override
    public MedicalAppointmentResponse deleteMedicalAppointment(UUID uuid) {
        return null;
    }
}
