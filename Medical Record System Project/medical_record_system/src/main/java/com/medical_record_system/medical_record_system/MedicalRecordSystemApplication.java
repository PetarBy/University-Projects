package com.medical_record_system.medical_record_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(
  scanBasePackages = "com.medical_record_system"
)
@EntityScan("com.medical_record_system.model.entity")
@EnableJpaRepositories("com.medical_record_system.repository")
public class MedicalRecordSystemApplication {
    public static void main(String[] args) {
        SpringApplication.run(MedicalRecordSystemApplication.class, args);
    }
}
