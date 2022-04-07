package com.clinica.odontologica.controllers;

import com.clinica.odontologica.dao.impl.DentistDaoH2;
import com.clinica.odontologica.model.DentistDTO;
import com.clinica.odontologica.repository.entity.Address;
import com.clinica.odontologica.repository.entity.Dentist;

import com.clinica.odontologica.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.ResponseEntity.ok;


@RestController
public class DentistController {

    @Autowired
    DentistService dentistService;


    @PostMapping("/dentist")
    public DentistDTO registrarOdontologo(@RequestBody DentistDTO dentistDTO) {
        return dentistService.saveDentist(dentistDTO);

    }

    @GetMapping("/dentist")
    public List<DentistDTO> getAllDentistsDTO(){
        return dentistService.findAllDentists();
    }


//    @PutMapping()
//    public ResponseEntity<Odontologo> actualizar(@RequestBody Odontologo odontologo) {
//        ResponseEntity<Odontologo> response = null;
//
//        if (odontologo.getId() != null && odontologoService.buscar(odontologo.getId()) != null)
//            response = ResponseEntity.ok(odontologoService.actualizar(odontologo));
//        else
//            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//
//        return response;
//    }
//
//    @DeleteMapping("/{id}")
//    public ResponseEntity<String> eliminar(@PathVariable Integer id) {
//        ResponseEntity<String> response = null;
//
//        if (odontologoService.buscar(id) != null) {
//            odontologoService.eliminar(id);
//            response = ResponseEntity.status(HttpStatus.NO_CONTENT).body("Eliminado");
//        } else {
//            response = ResponseEntity.status(HttpStatus.NOT_FOUND).build();
//        }
//
//        return response;
//    }
//    @GetMapping
//    public ResponseEntity<List<Odontologo>> buscarTodos(){
//        return ResponseEntity.ok(odontologoService.buscarTodos());
//    }*/



}