package com.trainibit.xchel.medical_appointment.controller;

import com.trainibit.xchel.medical_appointment.request.AgeGroupRequest;
import com.trainibit.xchel.medical_appointment.response.AgeGroupResponse;
import com.trainibit.xchel.medical_appointment.response.StateAppointmentResponse;
import com.trainibit.xchel.medical_appointment.service.AgeGroupService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/age-group")
@CrossOrigin(origins = "http://localhost:4200")  // Permite solicitudes desde el frontend
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

    @PostMapping
    public AgeGroupResponse saveUser(@Valid @RequestBody AgeGroupRequest userRequest) {
        return ageGroupService.save(userRequest);
    }

    @PutMapping("/{uuid}")
    public ResponseEntity<AgeGroupResponse> updateUser(@PathVariable UUID uuid ,@RequestBody AgeGroupRequest userRequest) {
        return ResponseEntity.ok(ageGroupService.update(uuid, userRequest));
    }
    @DeleteMapping("/{uuid}")
    public ResponseEntity<AgeGroupResponse> deleteUser(@PathVariable UUID uuid) {
        return ResponseEntity.status(204).body(ageGroupService.delete(uuid));
    }

    @PutMapping("/procedeupdate/{uuid}")
    public ResponseEntity<AgeGroupResponse> updateAgeGroup(
            @PathVariable UUID uuid,
            @RequestParam String description,
            @RequestParam Boolean state) {
        return ResponseEntity.ok(ageGroupService.updateAgeGroup(uuid, description, state));
    }
    @DeleteMapping("/precededelete/{uuid}")
    public ResponseEntity<AgeGroupResponse> deleteAge(@PathVariable UUID uuid) {
        return ResponseEntity.ok(ageGroupService.deleteAgeGroup(uuid));
    }

    @PostMapping("/procedecreate")
    public ResponseEntity<AgeGroupResponse> createAgeGroup(
            @RequestParam String description,
            @RequestParam Boolean state) {
        return ResponseEntity.ok(ageGroupService.createAgeGroup(description, state));
    }

}