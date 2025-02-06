package com.trainibit.xchel.medical_appointment.repository;

import com.trainibit.xchel.medical_appointment.entity.Speciality;
import com.trainibit.xchel.medical_appointment.entity.StateAppointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface SpecilalityRespository extends JpaRepository <Speciality, Long> {
    List<Speciality> findAll();
    Speciality findByUuid(UUID uuid);


}
