package com.trainibit.xchel.medical_appointment.controller;

import com.trainibit.xchel.medical_appointment.entity.MedicalAppointment;
import com.trainibit.xchel.medical_appointment.request.MedicalAppointmentRequest;
import com.trainibit.xchel.medical_appointment.response.MedicalAppointmentResponse;
import com.trainibit.xchel.medical_appointment.service.MedicalAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/medical-appointment")
@CrossOrigin(origins = "http://localhost:4200")  // Permite solicitudes desde el frontend

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

    @PutMapping("/{uuid}")
    public ResponseEntity<MedicalAppointmentResponse> updateUser(@PathVariable UUID uuid, @RequestBody MedicalAppointmentRequest medicalAppointmentRequest) {
        return ResponseEntity.ok(medicalAppointmentService.update(uuid, medicalAppointmentRequest));
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<MedicalAppointmentResponse> deleteUser(@PathVariable UUID uuid) {
        return ResponseEntity.status(200).body(medicalAppointmentService.delete(uuid));
    }
    @PostMapping("/procedecreate")
    public ResponseEntity<MedicalAppointmentResponse> procedecreate(
            @RequestParam String scheduledForStr,
            @RequestParam String reason,
            @RequestParam String stateAppointmentUuid,
            @RequestParam String doctorUuid,
            @RequestParam String assistant,
            @RequestParam Boolean state) {

        Timestamp scheduledFor = Timestamp.valueOf(scheduledForStr);
        return ResponseEntity.ok(
                medicalAppointmentService.createMedicalAppointment(
                        scheduledFor, reason, stateAppointmentUuid, doctorUuid, assistant, state
                )
        );
    }

}

