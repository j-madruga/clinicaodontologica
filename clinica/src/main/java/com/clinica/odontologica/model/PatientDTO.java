package com.clinica.odontologica.model;

import com.clinica.odontologica.repository.entity.Address;
import com.clinica.odontologica.repository.entity.Appointment;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class PatientDTO {

    private Long id = null;
    private String dni;
    private String name;
    private String lastName;
    private LocalDate admissionDate;
    private LocalDate dischargeDate;
    private Address address;
    private Set<Appointment> appointments = new HashSet<>();

}
