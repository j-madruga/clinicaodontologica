package com.clinica.odontologica.controllers;

import com.clinica.odontologica.exception.AppointmentException;
import com.clinica.odontologica.exception.ControllerExceptionHandler;
import com.clinica.odontologica.model.AppointmentDTO;
import com.clinica.odontologica.repository.entity.Appointment;
import com.clinica.odontologica.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/appointment")
@CrossOrigin(origins = "*")
public class AppointmentController {

    @Autowired
    AppointmentService appointmentService;
    LocalDate currentDate =  LocalDate.now();
    @PostMapping("/new")
    public ResponseEntity<AppointmentDTO> saveNewAppointment(@RequestBody AppointmentDTO appointmentDTO) throws AppointmentException {
        ResponseEntity<AppointmentDTO> response = ResponseEntity.notFound().build();
        if(appointmentDTO.getDate().isBefore(currentDate)) {
            throw new AppointmentException("Can't save an appointment with a past date.");
        } else {
              response = ResponseEntity.ok(appointmentService.saveAppointment(appointmentDTO));
        }
        return response;
    }

    @GetMapping()
    public List<AppointmentDTO> getALlAppointments(){
        return appointmentService.getAllAppointments();
    }

    @GetMapping("/{id}")
    public AppointmentDTO getAppointmentById(@PathVariable Long id){
        return appointmentService.getAppointmentById(id);
    }

    @PutMapping
    public ResponseEntity<?> updateAppointment(@RequestBody AppointmentDTO appointmentDTO){
        appointmentService.updateAppointment(appointmentDTO);
        return ResponseEntity.status(HttpStatus.OK).body("Appointment edited successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAppointment(@PathVariable Long id){
        appointmentService.deleteAppointment(id);
        return ResponseEntity.status(HttpStatus.OK).body("Appointment cancelled");
    }

    @ExceptionHandler({AppointmentException.class})
    public ResponseEntity exceptionProcess(AppointmentException ex){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}
