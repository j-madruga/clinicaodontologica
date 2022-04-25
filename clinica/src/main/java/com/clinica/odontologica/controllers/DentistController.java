package com.clinica.odontologica.controllers;

import com.clinica.odontologica.model.DentistDTO;
import com.clinica.odontologica.service.DentistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentist")
@CrossOrigin(origins = "*")
public class DentistController {

    @Autowired
    DentistService dentistService;

    /**
     * Returns (if exists) the dentist that matches the given id
     * GET: /dentist/{id}
     *
     * @param id id of the dentist that is being searched
     * @return json
     */
    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> getDentistById(@PathVariable Long id) {
        ResponseEntity<DentistDTO> response = ResponseEntity.notFound().build();
        DentistDTO dentistDTO = dentistService.findById(id);
        if (dentistDTO != null) {
            response = ResponseEntity.ok(dentistDTO);
        }
        return response;
    }

    /**
     * Returns a list with all the dentists
     * GET: /dentist
     *
     * @return json
     */
    @GetMapping("/all")
    public List<DentistDTO> findAllDentists() {
        return dentistService.findAllDentists();
    }

    /**
     * Allows to save a new dentist
     * POST: /dentist/save
     *
     * @param dentistDTO a json object representing a dentist
     * @return json
     */
    @PostMapping("/save")
    public DentistDTO saveDentist(@RequestBody DentistDTO dentistDTO) {
        return dentistService.saveDentist(dentistDTO);

    }

    /**
     * Returns (if exists) the dentist that matches the license
     * GET: /dentist/{license}
     *
     * @param license the dentist license
     * @return json
     */
/*    @GetMapping("/{license}")
    public ResponseEntity<?> findDentistByLicense(@RequestParam String license) {
        DentistDTO dentistFound = dentistService.findByLicense(license);
        if (dentistFound == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("no estaria estando el dentista");
        } else {
            return ResponseEntity.ok().body(dentistFound);
        }
    }*/

    /**
     * Returns (if exists) the updated dentist that matches the id
     * PUT: /dentist/update
     *
     * @param dentistDTO the dentist with updated info
     * @return json
     */
    @PutMapping("/update")
    public ResponseEntity<DentistDTO> updateDentist(@RequestBody DentistDTO dentistDTO) {
        ResponseEntity<DentistDTO> response = ResponseEntity.notFound().build();
        if (dentistDTO.getId() != null) {
            DentistDTO dentistUpdated = dentistService.updateDentist(dentistDTO);
            if (dentistUpdated != null) {
                response = ResponseEntity.ok().body(dentistUpdated);
            }
        }
        return response;
    }

    /**
     * Deletes the dentists that matches the id
     * DELETE: /dentist/delete
     *
     * @param id the id of the dentist to be deleted
     * @return json
     */
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteDentistById(@PathVariable Long id) {
        String message = dentistService.deleteDentistById(id);
        return ResponseEntity.ok(message);
    }

}