package com.trainibit.xchel.medical_appointment.controller;

import com.trainibit.xchel.medical_appointment.request.StateAppointmentRequest;
import com.trainibit.xchel.medical_appointment.response.StateAppointmentResponse;
import com.trainibit.xchel.medical_appointment.service.StateAppointmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/state-appointment")
public class StateAppointmentController {

    @Autowired
    private StateAppointmentService stateAppointmentService;

    @GetMapping
    public ResponseEntity<List<StateAppointmentResponse>>getStateAppointment() {
        return ResponseEntity.ok(stateAppointmentService.findAll());
    }

    @GetMapping("/{uuid}")
    public StateAppointmentResponse getUserById (@PathVariable UUID uuid) {
        return stateAppointmentService.findByUuid(uuid);
    }

    @PostMapping
    public StateAppointmentResponse saveUser(@Valid @RequestBody StateAppointmentRequest userRequest) {
        return stateAppointmentService.save(userRequest);
    }
    @PutMapping("/{uuid}")
    public ResponseEntity<StateAppointmentResponse> updateUser(@PathVariable UUID uuid, @RequestBody StateAppointmentRequest userRequest) {
        return ResponseEntity.ok(stateAppointmentService.update(uuid, userRequest));
    }
    @DeleteMapping("/{uuid}")
public ResponseEntity<StateAppointmentResponse> deleteUser(@PathVariable UUID uuid) {
        return ResponseEntity.status(204).body(stateAppointmentService.delete(uuid));
    }
}
