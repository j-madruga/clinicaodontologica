package com.clinica.odontologica.repository.entity;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "APPOINTMENT")
public class Appointment {

    @Id
    @SequenceGenerator(name="appointment_sequence", sequenceName = "appointment_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_sequence")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_patient", nullable = false)
    private Patient patient;
    @ManyToOne
    @JoinColumn(name = "id_dentist", nullable = false)
    private Dentist dentist;
    @Column(name = "date")
    private LocalDate date;

}
