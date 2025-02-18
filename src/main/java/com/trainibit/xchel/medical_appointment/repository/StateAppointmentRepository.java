package com.trainibit.xchel.medical_appointment.repository;


import com.trainibit.xchel.medical_appointment.entity.StateAppointment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface StateAppointmentRepository extends JpaRepository<StateAppointment, Long> {
    StateAppointment findByUuid(UUID uuid);
}
