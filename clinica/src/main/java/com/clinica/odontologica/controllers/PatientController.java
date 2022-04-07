package com.clinica.odontologica.controllers;

import com.clinica.odontologica.repository.entity.Address;
import com.clinica.odontologica.repository.irepository.IAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientController {
    @Autowired
    IAddressRepository iAddressRepository;

    @GetMapping("/getPatientById")
    public ResponseEntity<List<Address>> getPatientsByAdressId(Long idAddress) {
        return ResponseEntity.ok(iAddressRepository.getAddressByPatientId(idAddress));

    }
}
