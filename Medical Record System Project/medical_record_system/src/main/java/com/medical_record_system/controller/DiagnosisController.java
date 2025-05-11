package com.medical_record_system.controller;

import com.medical_record_system.model.entity.Diagnosis;
import com.medical_record_system.service.DiagnosisService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/diagnoses")
public class DiagnosisController {

    private final DiagnosisService diagnosisService;

    public DiagnosisController(DiagnosisService diagnosisService) {
        this.diagnosisService = diagnosisService;
    }

    // Create a new diagnosis
    @PostMapping
    public ResponseEntity<Diagnosis> createDiagnosis(@Valid @RequestBody Diagnosis diagnosis) {
        return ResponseEntity.ok(diagnosisService.createDiagnosis(diagnosis));
    }

    // Get all diagnoses
    @GetMapping
    public ResponseEntity<List<Diagnosis>> getAllDiagnoses() {
        return ResponseEntity.ok(diagnosisService.getAllDiagnoses());
    }

    // Get diagnosis by ID
    @GetMapping("/{id}")
    public ResponseEntity<Diagnosis> getDiagnosisById(@PathVariable Long id) {
        return ResponseEntity.ok(diagnosisService.getDiagnosisById(id));
    }

    // Update a diagnosis
    @PutMapping("/{id}")
    public ResponseEntity<Diagnosis> updateDiagnosis(
            @PathVariable Long id,
            @Valid @RequestBody Diagnosis diagnosis
    ) {
        return ResponseEntity.ok(diagnosisService.updateDiagnosis(id, diagnosis));
    }

    // Delete a diagnosis
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDiagnosis(@PathVariable Long id) {
        diagnosisService.deleteDiagnosis(id);
        return ResponseEntity.noContent().build();
    }
}
