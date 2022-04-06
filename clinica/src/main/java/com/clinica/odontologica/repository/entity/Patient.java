package com.clinica.odontologica.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

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
    private Date admissionDate;
    @Column(name = "discharge_date")
    private Date dischargeDate;

    public Patient(Long id, String dni, String name, String lastName, Date admissionDate, Date dischargeDate) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
    }

    public Patient(String dni, String name, String lastName, Date admissionDate, Date dischargeDate) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
    }

    public Patient() {
    }

    @Override
    public String toString() {
        return "Patient{" +
                "id=" + id +
                ", dni='" + dni + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", admissionDate=" + admissionDate +
                ", dischargeDate=" + dischargeDate +
                '}';
    }

}
