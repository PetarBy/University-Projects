package com.medical_record_system.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.medical_record_system.model.entity.Doctor;

@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    Doctor findByName(String name);

    
    List<Doctor> findByIsPersonalDoctorTrue();

}
