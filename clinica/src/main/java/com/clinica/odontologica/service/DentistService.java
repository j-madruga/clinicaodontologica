package com.clinica.odontologica.service;

import com.clinica.odontologica.model.DentistDTO;
import com.clinica.odontologica.repository.entity.Dentist;
import com.clinica.odontologica.repository.irepository.IDentistRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DentistService {

    public DentistService() {
    }

    @Autowired
    public void setiDentistRepository(IDentistRepository iDentistRepository) {
        this.iDentistRepository = iDentistRepository;
    }

    private IDentistRepository iDentistRepository;

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    private ObjectMapper objectMapper;

    final static Logger logger = LogManager.getLogger(DentistService.class);

    public DentistDTO findById(Long id) {
        DentistDTO dentistDTO = null;
        Optional<Dentist> foundDentist = iDentistRepository.findById(id);
        if (foundDentist.isPresent()) {
            dentistDTO = objectMapper.convertValue(foundDentist.get(), DentistDTO.class);
        }
        return dentistDTO;
    }

    public List<DentistDTO> findAllDentists() {
        List<Dentist> dentistList = iDentistRepository.findAll();
        List<DentistDTO> dentistDTOList = new ArrayList<>();
        dentistList.forEach(dentist -> dentistDTOList.add(objectMapper.convertValue(dentist, DentistDTO.class)));
        return dentistDTOList;
    }

    public DentistDTO saveDentist(DentistDTO dentistDTO) {
        Dentist dentist = objectMapper.convertValue(dentistDTO, Dentist.class);
        Dentist savedDentist = iDentistRepository.save(dentist);
        return objectMapper.convertValue(savedDentist, DentistDTO.class);
    }

/*    public DentistDTO findByLicense(String license) {
        DentistDTO dentistDTO = null;
        Optional<Dentist> dentistEntity = iDentistRepository.findByLicense(license);
        if (!dentistEntity.isPresent()) {
            return dentistDTO;
        } else {
            dentistDTO = objectMapper.convertValue(dentistEntity.get(), DentistDTO.class);
        }
        return dentistDTO;
    }*/

    public DentistDTO updateDentist(DentistDTO dentistDTO) {
        DentistDTO updatedDentistDTO = null;
        Dentist dentist = objectMapper.convertValue(dentistDTO, Dentist.class);
        if (iDentistRepository.findById(dentist.getId()).isPresent()) {
            Dentist dentistSaved = iDentistRepository.save(dentist);
            updatedDentistDTO = objectMapper.convertValue(dentistSaved, DentistDTO.class);
        }
        return updatedDentistDTO;
    }

    public String deleteDentistById(Long id) {
        String message = "Cant find dentist that matches the given id.";
        Optional<Dentist> dentistToDelete = iDentistRepository.findById(id);
        if (dentistToDelete.isPresent()) {
            iDentistRepository.delete(dentistToDelete.get());
            message = "Dentist deleted successfully.";
        }
        return message;
    }
}
