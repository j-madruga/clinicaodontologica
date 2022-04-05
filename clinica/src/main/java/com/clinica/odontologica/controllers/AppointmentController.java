package com.clinica.odontologica.controllers;

import com.clinica.odontologica.repository.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentController {

//    @Autowired
//    AppointmentRepository coso;

    @GetMapping("/appointments")
    public List<Appointment> getALlAppointments(){
        return null;
    }
}
