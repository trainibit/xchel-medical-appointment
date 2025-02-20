package com.trainibit.xchel.medical_appointment.repository;


import com.trainibit.xchel.medical_appointment.entity.StateAppointment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StateAppointmentRepository extends JpaRepository<StateAppointment,Long> {
    StateAppointment findByUuid(UUID uuid);
}
