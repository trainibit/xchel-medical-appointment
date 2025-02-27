package com.trainibit.xchel.medical_appointment.repository;

import com.trainibit.xchel.medical_appointment.entity.MedicalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.UUID;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {

    MedicalAppointment findByUuid(UUID uuid);
}
