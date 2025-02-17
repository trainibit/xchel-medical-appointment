package com.trainibit.xchel.medical_appointment.controller;

import com.trainibit.xchel.medical_appointment.entity.Speciality;
import com.trainibit.xchel.medical_appointment.request.SpecialityRequest;
import com.trainibit.xchel.medical_appointment.response.AgeGroupResponse;
import com.trainibit.xchel.medical_appointment.response.SpecialityResponse;
import com.trainibit.xchel.medical_appointment.service.SpecialityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/speciality")

public class SpecialityController {

    @Autowired
    private SpecialityService specialityService;

    @GetMapping
    public ResponseEntity<List<SpecialityResponse>> getSpeciality() {
        return ResponseEntity.ok(specialityService.findAll());

    }

    @GetMapping("/{uuid}")
    public SpecialityResponse getUserById(@PathVariable UUID uuid) {
        return specialityService.findByUuid(uuid);
    }


    @PostMapping
    public SpecialityResponse saveUser(@RequestBody SpecialityRequest specialityRequest) {
        return specialityService.save(specialityRequest);
    }
}
