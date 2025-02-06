package com.trainibit.xchel.medical_appointment.repository;

import com.trainibit.xchel.medical_appointment.entity.MedicalAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface MedicalAppointmentRepository extends JpaRepository<MedicalAppointment, Long> {
    List<MedicalAppointment> findAll();
    MedicalAppointment findByUuid(UUID uuid);
}
