package com.trainibit.xchel.medical_appointment.controller;

import com.trainibit.xchel.medical_appointment.response.AgeGroupResponse;
import com.trainibit.xchel.medical_appointment.service.AgeGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/appointment")
public class AgeGroupController {

    @Autowired
    private AgeGroupService ageGroupService;


    @GetMapping
    public ResponseEntity<List<AgeGroupResponse>> getAgeGroup() {

        return ResponseEntity.ok(ageGroupService.findAll());
    }
    @GetMapping("/{uuid}")
    public AgeGroupResponse getUserById(@PathVariable UUID uuid) {
        return ageGroupService.findByUuid(uuid);
    }



}
