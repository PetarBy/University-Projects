package com.medical_record_system.controller;

import com.medical_record_system.model.entity.SickLeave;
import com.medical_record_system.service.SickLeaveService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/sick-leaves")
public class SickLeaveController {

    private final SickLeaveService sickLeaveService;

    public SickLeaveController(SickLeaveService sickLeaveService) {
        this.sickLeaveService = sickLeaveService;
    }

    // Create a new sick leave
    @PostMapping
    public ResponseEntity<SickLeave> createSickLeave(@Valid @RequestBody SickLeave sickLeave) {
        return ResponseEntity.ok(sickLeaveService.createSickLeave(sickLeave));
    }

    // Get all sick leaves
    @GetMapping
    public ResponseEntity<List<SickLeave>> getAllSickLeaves() {
        return ResponseEntity.ok(sickLeaveService.getAllSickLeaves());
    }

    // Get sick leave by ID
    @GetMapping("/{id}")
    public ResponseEntity<SickLeave> getSickLeaveById(@PathVariable Long id) {
        return ResponseEntity.ok(sickLeaveService.getSickLeaveById(id));
    }

    // Update a sick leave
    @PutMapping("/{id}")
    public ResponseEntity<SickLeave> updateSickLeave(
            @PathVariable Long id,
            @Valid @RequestBody SickLeave sickLeave
    ) {
        return ResponseEntity.ok(sickLeaveService.updateSickLeave(id, sickLeave));
    }

    // Delete a sick leave
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSickLeave(@PathVariable Long id) {
        sickLeaveService.deleteSickLeave(id);
        return ResponseEntity.noContent().build();
    }
}
