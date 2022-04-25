package com.clinica.odontologica.model;

import com.clinica.odontologica.repository.entity.Dentist;
import com.clinica.odontologica.repository.entity.Patient;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class AppointmentDTO {
    private Long id;
    private Patient patient;
    private Dentist dentist;
    private LocalDate date;
}
