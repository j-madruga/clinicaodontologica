package com.clinica.odontologica.service;

import com.clinica.odontologica.model.PatientDTO;
import com.clinica.odontologica.repository.entity.Patient;
import com.clinica.odontologica.repository.irepository.IPatientRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PatientService {

    @Autowired
    IPatientRepository iPatientRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public PatientDTO getById(Long id) {
        PatientDTO response = null;
        Optional<Patient> foundPatient = iPatientRepository.findById(id);
        if(foundPatient.isPresent()) {
            response = objectMapper.convertValue(foundPatient.get(), PatientDTO.class);
        }
        return response;
    }

    public List<PatientDTO> findAllPatients(){
        return iPatientRepository.findAll()
                .stream()
                .map(patient -> objectMapper.convertValue(patient,PatientDTO.class))
                .collect(Collectors.toList());
    }

    public PatientDTO savePatient(PatientDTO patientDTO) {
        PatientDTO response = null;
        Patient patientToSave = objectMapper.convertValue(patientDTO,Patient.class);
        Patient savedPatient = iPatientRepository.save(patientToSave);
        if(savedPatient.getId() != null) {
            response = objectMapper.convertValue(savedPatient, PatientDTO.class);
        }
        return response;
    }

    public void deletePatient(Long id) {
        iPatientRepository.deleteById(id);
    }

    public Patient findPatientById(Long id) {
        Optional<Patient> foundPatient = iPatientRepository.findById(id);
        return foundPatient.orElse(null);
    }

    public Patient updatePatient(Patient p) {
        return iPatientRepository.save(p);
    }

}
