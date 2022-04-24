package com.clinica.odontologica.controllers;

import com.clinica.odontologica.repository.entity.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {

//    @Autowired
//    AppointmentRepository coso;

    @GetMapping()
    public List<Appointment> getALlAppointments(){
        return null;
    }
}
