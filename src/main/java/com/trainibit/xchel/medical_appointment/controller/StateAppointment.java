package com.trainibit.xchel.medical_appointment.controller;

import com.trainibit.xchel.medical_appointment.request.StateAppointmentRequest;
import com.trainibit.xchel.medical_appointment.response.StateAppointmentResponse;
import com.trainibit.xchel.medical_appointment.service.StateAppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("/state-appointment")
@RestController
public class StateAppointment {
    @Autowired
    private StateAppointmentService stateAppointmentService;

    @GetMapping
    public ResponseEntity<List<StateAppointmentResponse>>getStateAppointment() {
        return ResponseEntity.ok(stateAppointmentService.findAll());
    }

    @GetMapping("/{uuid}")
    public StateAppointmentResponse getUserById (@PathVariable UUID uuid) {
        return stateAppointmentService.findByUUID(uuid);
    }

    @PostMapping
    public StateAppointmentResponse saveUser(@RequestBody StateAppointmentRequest stateAppointmentRequest) {
        return stateAppointmentService.save(stateAppointmentRequest);
    }
}
