package com.clinica.odontologica.service;

import com.clinica.odontologica.model.AppointmentDTO;
import com.clinica.odontologica.repository.entity.Appointment;
import com.clinica.odontologica.repository.irepository.IAppointmentRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    @Autowired
    IAppointmentRepository iAppointmentRepository;

    @Autowired
    ObjectMapper objectMapper;

    public AppointmentDTO saveAppointment(AppointmentDTO appointmentDTO) {
        Appointment appointment = objectMapper.convertValue(appointmentDTO, Appointment.class);
        return objectMapper.convertValue(iAppointmentRepository.save(appointment), AppointmentDTO.class);
    }

    public List<AppointmentDTO> getAllAppointments() {
        List<Appointment> appointments = iAppointmentRepository.findAll();
        List<AppointmentDTO> appointmentDTOS = appointments.stream()
                .map(appointment -> objectMapper.convertValue(appointment, AppointmentDTO.class))
                .collect(Collectors.toList());
        return appointmentDTOS;
    }

    public AppointmentDTO getAppointmentById(Long id) {
        Optional<Appointment> appointment = iAppointmentRepository.findById(id);
        AppointmentDTO appointmentDTO = null;
        if(appointment.isPresent()){
            appointmentDTO = objectMapper.convertValue(appointmentDTO, AppointmentDTO.class);
        }
        return appointmentDTO;
    }

    public void updateAppointment(AppointmentDTO appointmentDTO) {
        saveAppointment(appointmentDTO);
    }

    public void deleteAppointment(Long id) {
        iAppointmentRepository.deleteById(id);
    }
}
