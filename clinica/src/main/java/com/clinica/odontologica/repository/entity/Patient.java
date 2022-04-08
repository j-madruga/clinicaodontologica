package com.clinica.odontologica.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "PATIENT")
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) // no se borra xq otros pacientes pueden tener la misma direccion
    @JoinColumn(name = "id_address", referencedColumnName = "id")
    private Address address;
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY)
    private Set<Appointment> appointmensts = new HashSet<>();

}
