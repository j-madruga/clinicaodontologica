package com.clinica.odontologica.controllers;

import com.clinica.odontologica.exception.ControllerExceptionHandler;
import com.clinica.odontologica.model.PatientDTO;
import com.clinica.odontologica.service.PatientService;
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
    PatientService patientService;

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
     * Saves a new patient (with his address)
     * POST: /patient/save
     *
     * @param patientDTO: the patient to be saved
     * @return json with the saved patient including the generated id
     */
    @PostMapping("/save")
    public ResponseEntity<PatientDTO> savePatient(@RequestBody PatientDTO patientDTO) {
        return ResponseEntity.ok(patientService.savePatient(patientDTO));
    }

    /**
     * Updates an existing patient and his address
     * POST: /patient/save-with-address
     *
     * @param patientDTO: the patient to be saved
     * @return json with the saved patient including the address
     */
    @PutMapping("/update")
    public ResponseEntity<PatientDTO> updatePatientAndAddress(@RequestBody PatientDTO patientDTO) {
        ResponseEntity<PatientDTO> response = ResponseEntity.notFound().build();
        PatientDTO updatedPatient = patientService.updatePatient(patientDTO);
        if(updatedPatient.getId() != null) {
            response = ResponseEntity.ok(updatedPatient);
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
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> detelePatientById(@PathVariable Long id) {
        ResponseEntity<String>  response = ResponseEntity.status(HttpStatus.NOT_FOUND).body("Patient not found");
        if (patientService.findPatientById(id) != null) {
            patientService.deletePatient(id);
            response = ResponseEntity.ok("Patient deleted correctly");
        }
        return response;
    }

}
