package com.trainibit.xchel.medical_appointment.repository;

import com.trainibit.xchel.medical_appointment.entity.AgeGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AgeGroupRepository extends JpaRepository<AgeGroup,Long> {
    List<AgeGroup> findAll();
    AgeGroup findByUuid(UUID uuid);

}
