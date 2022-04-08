package com.clinica.odontologica.service;

import com.clinica.odontologica.repository.entity.Patient;
import com.clinica.odontologica.repository.irepository.IPatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    IPatientRepository patientRepository;

    public List<Patient> findAllPatients(){
        return patientRepository.findAll();
    }

    public Patient savePatient(Patient p) {
        return patientRepository.save(p);
    }

    public void deletePatient(Long id) {
        patientRepository.deleteById(id);
    }

    public Patient findPatientById(Long id) {
        Optional<Patient> foundPatient = patientRepository.findById(id);
        return foundPatient.orElse(null);
    }

    public Patient updatePatient(Patient p) {
        return patientRepository.save(p);
    }

}
