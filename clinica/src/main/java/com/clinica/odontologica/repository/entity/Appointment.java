package com.clinica.odontologica.repository.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Getter
@Setter
@Table(name = "APPOINTMENT")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "id_patient")
    private Patient patient;
    @Column(name = "id_dentist")
    private Dentist dentist;
    @Column(name = "")
    private java.sql.Date date;

    public Appointment(Integer id, Patient patient, Dentist dentist, Date date) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }

    public Appointment(Patient patient, Dentist dentist, Date date) {
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }

    public Appointment() {
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "id=" + id +
                ", patient=" + patient +
                ", dentist=" + dentist +
                ", date=" + date +
                '}';
    }

}
