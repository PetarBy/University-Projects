package com.medical_record_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.medical_record_system.model.entity.Patient;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    List<Patient> findByPersonalDoctorId(Long doctorId);

    Patient findByEgn(String egn);

    boolean existsByEgn(String egn);
}
