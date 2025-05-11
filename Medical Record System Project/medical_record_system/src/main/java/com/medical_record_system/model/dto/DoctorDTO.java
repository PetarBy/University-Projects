package com.medical_record_system.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class DoctorDTO {

    private Long id;

    @NotBlank(message = "Doctor name is required")
    @Size(min = 2, max = 100, message = "Doctor name must be between 2 and 100 characters")
    private String name;

    @NotBlank(message = "Specialty is required")
    @Size(min = 2, max = 100, message = "Specialty must be between 2 and 100 characters")
    private String specialty;

    private boolean isPersonalDoctor; // whether this doctor is registered as a personal doctor

    public DoctorDTO() {}

    public DoctorDTO(Long id, String name, String specialty, boolean isPersonalDoctor) {
        this.id = id;
        this.name = name;
        this.specialty = specialty;
        this.isPersonalDoctor = isPersonalDoctor;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecialty() {
        return specialty;
    }

    public void setSpecialty(String specialty) {
        this.specialty = specialty;
    }

    public boolean isPersonalDoctor() {
        return isPersonalDoctor;
    }

    public void setPersonalDoctor(boolean personalDoctor) {
        isPersonalDoctor = personalDoctor;
    }
}
