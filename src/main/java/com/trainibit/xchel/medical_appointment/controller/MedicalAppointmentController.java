package com.trainibit.xchel.medical_appointment.controller;

import com.trainibit.xchel.medical_appointment.entity.MedicalAppointment;
import com.trainibit.xchel.medical_appointment.request.MedicalAppointmentRequest;
import com.trainibit.xchel.medical_appointment.response.MedicalAppointmentResponse;
import com.trainibit.xchel.medical_appointment.service.MedicalAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/medical-appointment")
public class MedicalAppointmentController {

    @Autowired
    private MedicalAppointmentService medicalAppointmentService;

    @GetMapping
    public ResponseEntity<List<MedicalAppointmentResponse>>getMedicalAppointments() {
        return ResponseEntity.ok(medicalAppointmentService.findAll());
    }
    @GetMapping("/{uuid}")
    public MedicalAppointmentResponse getUserById(@PathVariable UUID uuid) {
        return medicalAppointmentService.findByUuid(uuid);
    }
    @PostMapping
    public MedicalAppointmentResponse saveUser(@RequestBody MedicalAppointmentRequest medicalAppointmentRequest) {
        return medicalAppointmentService.save(medicalAppointmentRequest);
    }
}

