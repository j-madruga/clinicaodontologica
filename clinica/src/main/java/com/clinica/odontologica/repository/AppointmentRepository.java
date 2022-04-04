package com.clinica.odontologica.repository;

import com.clinica.odontologica.model.Appointment;
import com.clinica.odontologica.model.Dentist;
import com.clinica.odontologica.model.Patient;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class AppointmentRepository{

    public AppointmentRepository() {
    }

    //    @Override
    public Appointment save(Appointment appointment) {
        return null;
    }

//    @Override
    public Appointment findById(Long id) {
        return null;
    }

//    @Override
    public List<Appointment> findAll() {
        List<Appointment> appointments = new ArrayList<>();
        appointments.add(new Appointment(1, new Patient(), new Dentist(), new Date()));
        appointments.add(new Appointment(2, new Patient(), new Dentist(), new Date()));
        appointments.add(new Appointment(3, new Patient(), new Dentist(), new Date()));
        appointments.add(new Appointment(4, new Patient(), new Dentist(), new Date()));
        return appointments;
    }

//    @Override
    public Appointment updateName(Long id, String newName) {
        return null;
    }

//    @Override
    public void delete(Long id) {

    }
}
