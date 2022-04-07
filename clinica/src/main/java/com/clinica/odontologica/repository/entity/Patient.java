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
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // no se borra xq otros pacientes pueden tener la misma direccion
    @JoinColumn(name = "id_address", nullable = false)
    private Address address;

    public Patient(Long id, String dni, String name, String lastName, Date admissionDate, Date dischargeDate, Address addres) {
        this.id = id;
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.address = addres;
    }

    public Patient(String dni, String name, String lastName, Date admissionDate, Date dischargeDate, Address addres) {
        this.dni = dni;
        this.name = name;
        this.lastName = lastName;
        this.admissionDate = admissionDate;
        this.dischargeDate = dischargeDate;
        this.address = addres;
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
