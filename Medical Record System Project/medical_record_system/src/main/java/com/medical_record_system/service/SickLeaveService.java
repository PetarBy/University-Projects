package com.medical_record_system.service;

import com.medical_record_system.exception.ResourceNotFoundException;
import com.medical_record_system.model.entity.SickLeave;
import com.medical_record_system.repository.SickLeaveRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class SickLeaveService {

    private final SickLeaveRepository sickLeaveRepository;

    public SickLeaveService(SickLeaveRepository sickLeaveRepository) {
        this.sickLeaveRepository = sickLeaveRepository;
    }

    public SickLeave createSickLeave(SickLeave sickLeave) {
        return sickLeaveRepository.save(sickLeave);
    }

    public List<SickLeave> getAllSickLeaves() {
        return sickLeaveRepository.findAll();
    }

    public SickLeave getSickLeaveById(Long id) {
        return sickLeaveRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Sick Leave not found with ID: " + id));
    }

    public SickLeave updateSickLeave(Long id, SickLeave updatedSickLeave) {
        SickLeave existing = getSickLeaveById(id);
        existing.setStartDate(updatedSickLeave.getStartDate());
        existing.setEndDate(updatedSickLeave.getEndDate());
        existing.setReason(updatedSickLeave.getReason());
        existing.setAppointment(updatedSickLeave.getAppointment());
        return sickLeaveRepository.save(existing);
    }

    public void deleteSickLeave(Long id) {
        if (!sickLeaveRepository.existsById(id)) {
            throw new ResourceNotFoundException("Sick Leave not found with ID: " + id);
        }
        sickLeaveRepository.deleteById(id);
    }
}
