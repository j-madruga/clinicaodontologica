package com.clinica.odontologica.model;

import com.clinica.odontologica.repository.entity.Dentist;
import com.clinica.odontologica.repository.entity.Patient;
import java.time.LocalDate;

public class AppointmentDTO {
    private Long id;
    private Patient patient;
    private Dentist dentist;
    private LocalDate date;
}
