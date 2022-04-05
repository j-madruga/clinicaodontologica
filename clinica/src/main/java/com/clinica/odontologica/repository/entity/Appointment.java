package com.clinica.odontologica.repository.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import javax.persistence.Entity;
import java.util.Date;

public class Appointment {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private Patient patient;
    @Getter @Setter
    private Dentist dentist;
    @Getter @Setter
    private Date date;

    public Appointment() {

    }

    public Appointment(Integer id, Patient patient, Dentist dentist, Date date) {
        this.id = id;
        this.patient = patient;
        this.dentist = dentist;
        this.date = date;
    }

}
