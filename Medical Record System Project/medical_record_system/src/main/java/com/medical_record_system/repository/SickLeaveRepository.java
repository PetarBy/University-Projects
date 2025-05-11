package com.medical_record_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.medical_record_system.model.entity.SickLeave;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface SickLeaveRepository extends JpaRepository<SickLeave, Long> {

    List<SickLeave> findByStartDateBetween(LocalDate start, LocalDate end);

    long countByIssuedByDoctorId(Long doctorId);
}
