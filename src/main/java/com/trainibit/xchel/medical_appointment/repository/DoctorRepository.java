package com.trainibit.xchel.medical_appointment.repository;

import com.trainibit.xchel.medical_appointment.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
    List<Doctor> findAll();
    Doctor findByUuid(UUID uuid);
}
