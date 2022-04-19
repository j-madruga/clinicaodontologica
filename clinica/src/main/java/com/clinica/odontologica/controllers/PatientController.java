package com.clinica.odontologica.controllers;

import com.clinica.odontologica.exception.ControllerExceptionHandler;
import com.clinica.odontologica.model.PatientDTO;
import com.clinica.odontologica.repository.entity.Address;
import com.clinica.odontologica.repository.irepository.IAddressRepository;
import com.clinica.odontologica.service.AddressService;
import com.clinica.odontologica.service.PatientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patient")
@CrossOrigin(origins = "*")
public class PatientController {
    @Autowired
    IAddressRepository iAddressRepository;
    @Autowired
    PatientService patientService;
    @Autowired
    ObjectMapper objectMapper;
    @Autowired
    AddressService addressService;
    /**
     * Gets a patient by id
     * GET: /patient/{id}
     *
     * @param id: the id of the patient to be searched
     * @return json: a PatientDTO
     */
    @GetMapping("/{id}")
    public ResponseEntity<PatientDTO> getPatientById(@PathVariable Long id) throws ControllerExceptionHandler {
            return ResponseEntity.ok(patientService.getById(id));
    }

    /**
     * Gets (if exists) a patient by the address id
     * GET: /patient/search/{idAddress}
     *
     * @param idAddress: the id of the address to be searched
     * @return json: a PatientDTO
     */
    @GetMapping("/search/{idAddress}")
    public ResponseEntity<Address> getPatientsByAdressId(@PathVariable Long idAddress) {
        return ResponseEntity.ok(iAddressRepository.getById(idAddress));
    }

    /**
     * Gets a list with all the patients
     * GET: /patient/all
     *
     * @param
     * @return json with all the patients
     */
    @GetMapping("/all")
    public ResponseEntity<List<PatientDTO>> getAllPatients() {
        ResponseEntity<List<PatientDTO>> response = ResponseEntity.notFound().build();
        List<PatientDTO> patientList = patientService.findAllPatients();
        if (!patientList.isEmpty()) {
            response = ResponseEntity.ok(patientList);
        }
        return response;
    }

    /**
     * Saves a new patient
     * POST: /patient/save
     *
     * @param patientDTO: the patient to be saved
     * @return json with the saved patient including the generated id
     */
    @PostMapping("/save")
    public ResponseEntity<PatientDTO> savePatient(@RequestBody PatientDTO patientDTO) {
        return ResponseEntity.ok(patientService.savePatient(patientDTO));
    }

    @PostMapping("/save-with-address")
    public ResponseEntity<PatientDTO> savePatientAndAddress(@RequestBody PatientDTO patientDTO) {
        ResponseEntity<PatientDTO> response = ResponseEntity.notFound().build();
        PatientDTO savedPatient = null;
        Boolean isAddressSaved = addressService.saveAddressFromPatientDTO(patientDTO);
        if (isAddressSaved) {
            savedPatient = patientService.savePatient(patientDTO);
            if(savedPatient.getId() != null) {
                response = ResponseEntity.ok(savedPatient);
            }
        }
        return response;
    }

    /**
     * Deletes an existing patient
     * DELETE: /patient/{id}
     *
     * @param id: the id of the patient to be deleted
     * @return json with a string response
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> detelePatientById(@PathVariable Long id) {
        ResponseEntity<String> response = null;
        if (patientService.findPatientById(id) != null) {
            patientService.deletePatient(id);
            response = ResponseEntity.ok("Patient deleted correctly");
        } else {
            response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        }
        return response;
    }
}
