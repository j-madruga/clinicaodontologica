package com.clinica.odontologica.service;

import com.clinica.odontologica.dao.IDao;
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

    IDao<Dentist> dentistDaoH2 = null;

    final static Logger logger = LogManager.getLogger(DentistService.class);

    public DentistService(IDao<Dentist> dentistDao) {
        this.dentistDaoH2 = dentistDao;
    }

    public DentistDTO saveDentist(DentistDTO dentistDTO) {
        Dentist dentist = objectMapper.convertValue(dentistDTO, Dentist.class);
        Dentist savedDentist = iDentistRepository.save(dentist);
        return objectMapper.convertValue(savedDentist, DentistDTO.class);
    }

    public Dentist findDentistById(Long id) throws Exception {
        Dentist dentistFound = dentistDaoH2.findById(id);
        if (dentistFound.getLicense() == null) {
            Exception e = new Exception("No dentist found under given id.");
            logger.error(e.getMessage());
            throw e;
        }
        return dentistFound;
    }

    public List<DentistDTO> findAllDentists() {
        List<Dentist> dentistList = iDentistRepository.findAll();
        List<DentistDTO> dentistDTOList = new ArrayList<>();
        dentistList.forEach(dentist -> dentistDTOList.add(objectMapper.convertValue(dentist, DentistDTO.class)));
        return dentistDTOList;
    }

    public Dentist updateDentistName(Long id, String newName) throws Exception {
        if(dentistDaoH2.findById(id).getLicense() == null) {
            Exception e = new Exception("No dentist under given id.");
            logger.error(e.getMessage());
            throw e;
        }
        return dentistDaoH2.updateName(id, newName);
    }

    public String deleteDentist(Long id) {
        String message = "Can't delete, because there is no dentist found under given id.";
        Dentist dentistToDelete = dentistDaoH2.findById(id);
        if(dentistToDelete.getLicense() != null) {
            dentistDaoH2.delete(id);
            message = "Dentist successfully deleted.";
        }
        return message;
    }
}
