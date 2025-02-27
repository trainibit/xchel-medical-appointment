package com.trainibit.xchel.medical_appointment.service.Impl;


import com.trainibit.xchel.medical_appointment.entity.AgeGroup;
import com.trainibit.xchel.medical_appointment.entity.StateAppointment;
import com.trainibit.xchel.medical_appointment.mapper.StateAppointmentMapper;
import com.trainibit.xchel.medical_appointment.repository.StateAppointmentRepository;
import com.trainibit.xchel.medical_appointment.request.StateAppointmentRequest;
import com.trainibit.xchel.medical_appointment.response.StateAppointmentResponse;
import com.trainibit.xchel.medical_appointment.service.StateAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Service
public class StateAppointmentServiceImpl implements StateAppointmentService {
    @Autowired
    private StateAppointmentRepository stateAppointmentRepository;

    @Autowired
    private StateAppointmentMapper stateAppointmentMapper;


    @Override
    public List<StateAppointmentResponse> findAll() {
        return stateAppointmentMapper.entityListToResponseList(stateAppointmentRepository.findAll());
    }

    @Override
    public StateAppointmentResponse findByUuid(UUID uuid) {
        return stateAppointmentMapper.entityToResponse(stateAppointmentRepository.findByUuid(uuid));
    }

    @Override
    public StateAppointmentResponse save(StateAppointmentRequest stateAppointmentRequest) {
        StateAppointment stateAppointment=stateAppointmentMapper.requestToEntity(stateAppointmentRequest);
        stateAppointment.setUuid(UUID.randomUUID());
        StateAppointment savedStateAppointment=stateAppointmentRepository.save(stateAppointment);
        return stateAppointmentMapper.entityToResponse(savedStateAppointment);
    }

    @Override
    public StateAppointmentResponse update(UUID uuid, StateAppointmentRequest stateAppointmentRequest) {
        StateAppointment existentUser = stateAppointmentRepository.findByUuid(uuid);

        existentUser.setDescription(
                stateAppointmentRequest.getDescription() != null ? stateAppointmentRequest.getDescription() : existentUser.getDescription());
        existentUser.setState(
                stateAppointmentRequest.getState() != null ? stateAppointmentRequest.getState() : existentUser.getState());

        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        existentUser.setUpdatedDate(currentTimeStamp);

        return stateAppointmentMapper.entityToResponse(stateAppointmentRepository.save(existentUser));
    }

    @Override
    public StateAppointmentResponse delete(UUID uuid) {
        StateAppointment userToDelete = stateAppointmentRepository.findByUuid(uuid);
        stateAppointmentRepository.delete(userToDelete);
        return stateAppointmentMapper.entityToResponse(userToDelete);
    }
}
