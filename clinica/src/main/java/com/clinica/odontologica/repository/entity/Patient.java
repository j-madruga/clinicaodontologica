package com.clinica.odontologica.repository.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "PATIENT")
public class Patient {

    @Id
    @SequenceGenerator(name="patient_sequence", sequenceName = "patient_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_sequence")
    private Long id = null;
    @Column(name = "dni")
    private String dni;
    @Column(name = "name")
    private String name;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "admission_date")
    private LocalDate admissionDate;
    @Column(name = "discharge_date")
    private LocalDate dischargeDate;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private Address address;
    /* esto no esta en la tabla DENTIST, lo trae java, x eso necesita el mappedBy */
    @OneToMany(mappedBy = "patient")
    @JsonIgnore
    private Set<Appointment> appointments = new HashSet<>();

}
