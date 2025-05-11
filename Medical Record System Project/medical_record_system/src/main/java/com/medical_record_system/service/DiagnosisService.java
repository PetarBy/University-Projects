package com.medical_record_system.service;

import com.medical_record_system.exception.ResourceNotFoundException;
import com.medical_record_system.model.entity.Diagnosis;
import com.medical_record_system.repository.DiagnosisRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiagnosisService {

    private final DiagnosisRepository diagnosisRepository;

    public DiagnosisService(DiagnosisRepository diagnosisRepository) {
        this.diagnosisRepository = diagnosisRepository;
    }

    public Diagnosis createDiagnosis(Diagnosis diagnosis) {
        return diagnosisRepository.save(diagnosis);
    }

    public List<Diagnosis> getAllDiagnoses() {
        return diagnosisRepository.findAll();
    }

    public Diagnosis getDiagnosisById(Long id) {
        return diagnosisRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Diagnosis not found with ID: " + id));
    }

    public Diagnosis updateDiagnosis(Long id, Diagnosis updatedDiagnosis) {
        Diagnosis existing = getDiagnosisById(id);
        existing.setName(updatedDiagnosis.getName());
        existing.setDescription(updatedDiagnosis.getDescription());
        existing.setMedications(updatedDiagnosis.getMedications());
        return diagnosisRepository.save(existing);
    }

    public void deleteDiagnosis(Long id) {
        if (!diagnosisRepository.existsById(id)) {
            throw new ResourceNotFoundException("Diagnosis not found with ID: " + id);
        }
        diagnosisRepository.deleteById(id);
    }
}
