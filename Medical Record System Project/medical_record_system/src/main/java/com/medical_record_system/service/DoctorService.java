package com.medical_record_system.service;

import org.springframework.stereotype.Service;
import com.medical_record_system.exception.ResourceNotFoundException;
import com.medical_record_system.model.entity.Doctor;
import com.medical_record_system.repository.DoctorRepository;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor createDoctor(Doctor doctorDTO) {
        // Save a new doctor to the database
        return doctorRepository.save(doctorDTO);
    }

    public Doctor getDoctorById(Long id) {
        // Get doctor or throw custom exception
        return doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + id));
    }

    public List<Doctor> getAllDoctors() {
        // Return all doctors
        return doctorRepository.findAll();
    }

    public Doctor updateDoctor(Long id, Doctor updatedDoctor) {
        // Update existing doctor
        Doctor doctor = doctorRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor not found with ID: " + id));

        doctor.setName(updatedDoctor.getName());
        doctor.setSpecialization(updatedDoctor.getSpecialization());
        doctor.setIsPersonalDoctor(updatedDoctor.getIsPersonalDoctor());

        return doctorRepository.save(doctor);
    }

    public void deleteDoctor(Long id) {
        // Delete doctor if found
        if (!doctorRepository.existsById(id)) {
            throw new ResourceNotFoundException("Doctor not found with ID: " + id);
        }
        doctorRepository.deleteById(id);
    }

    public List<Doctor> getAllPersonalDoctors() {
        // Return only doctors who are personal doctors
        return doctorRepository.findByIsPersonalDoctorTrue();
    }
}