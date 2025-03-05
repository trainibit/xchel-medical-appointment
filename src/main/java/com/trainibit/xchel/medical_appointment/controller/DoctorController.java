package com.trainibit.xchel.medical_appointment.controller;

import com.trainibit.xchel.medical_appointment.entity.Doctor;
import com.trainibit.xchel.medical_appointment.request.DoctorRequest;
import com.trainibit.xchel.medical_appointment.response.DoctorResponse;
import com.trainibit.xchel.medical_appointment.service.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/doctor")
@RestController
public class DoctorController {
    @Autowired
    private DoctorService doctorService;

    @GetMapping
    public ResponseEntity<List<DoctorResponse>> getDoctor() {
        return ResponseEntity.ok(doctorService.findAll());
    }
    @GetMapping("/{uuid}")
    public DoctorResponse getUserById(@PathVariable UUID  uuid) {
        return doctorService.findByUuid(uuid);
    }

    @PostMapping
    public DoctorResponse saveUser(@RequestBody DoctorRequest doctorRequest) {
        return doctorService.save(doctorRequest);
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<DoctorResponse> updateUser(@PathVariable UUID uuid, @RequestBody DoctorRequest doctorRequest) {
        return ResponseEntity.ok(doctorService.update(uuid, doctorRequest));
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<DoctorResponse> deleteUser(@PathVariable UUID uuid) {
        return ResponseEntity.ok(doctorService.delete(uuid));
    }
}