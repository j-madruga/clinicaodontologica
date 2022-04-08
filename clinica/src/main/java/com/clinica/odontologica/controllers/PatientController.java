package com.clinica.odontologica.controllers;

import com.clinica.odontologica.repository.entity.Address;
import com.clinica.odontologica.repository.irepository.IAddressRepository;
import com.clinica.odontologica.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    IAddressRepository iAddressRepository;
    @Autowired
    PatientService patientService;

//    @GetMapping("/getPatientById")
//    public ResponseEntity<List<Address>> getPatientsByAdressId(Long idAddress) {
//        return ResponseEntity.ok(iAddressRepository.getAddressByPatientId(idAddress));
//
//    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> detelePatientById(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        if(patientService.findPatientById(id) != null) {
            patientService.deletePatient(id);
            response = ResponseEntity.ok("Patient deleted correctly");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }
        return response;
    }
}
