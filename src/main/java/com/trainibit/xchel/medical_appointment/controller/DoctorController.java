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
@CrossOrigin(origins = "http://localhost:4200")  // Permite solicitudes desde el frontend
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
    @PostMapping("/precedecreate")
    public ResponseEntity<DoctorResponse> precedecreate(
            @RequestParam String specialtyUuid,
            @RequestParam String license,
            @RequestParam Boolean state) {
        return ResponseEntity.ok(doctorService.createDoctor(specialtyUuid, license, state));
    }

    @PutMapping("/procedeupdate/{uuid}")
    public ResponseEntity<DoctorResponse> procedeupdate(
            @PathVariable UUID uuid,
            @RequestParam String specialtyUuid,
            @RequestParam String license,
            @RequestParam Boolean state){
        return ResponseEntity.ok(doctorService.updateDoctor(uuid, specialtyUuid, license, state));
    }
    @DeleteMapping("/procededelete/{uuid}")
    public ResponseEntity<DoctorResponse> deleteDoctor(@PathVariable UUID uuid){
        return ResponseEntity.ok(doctorService.deleteDoctor(uuid));
    }
}