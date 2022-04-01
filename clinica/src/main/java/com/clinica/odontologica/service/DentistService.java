package com.clinica.odontologica.service;

import com.clinica.odontologica.dao.IDao;
import com.clinica.odontologica.model.Dentist;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class DentistService {

    IDao<Dentist> dentistDaoH2 = null;

    final static Logger logger = LogManager.getLogger(DentistService.class);

    public DentistService(IDao<Dentist> dentistDao) {
        this.dentistDaoH2 = dentistDao;
    }

    public String saveDentist(Dentist dentist) {
        Dentist dentistSaved = dentistDaoH2.save(dentist);
        if (dentistSaved.getId() != null) {
            return "Dentist saved successfully.";
        } else {
            return "Could not save dentist.";
        }
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

    public List<Dentist> findAllDentists() throws Exception{
        List<Dentist> dentistList = dentistDaoH2.findAll();
        if (dentistList.isEmpty()) {
                Exception e = new Exception("There are not dentists records at the database.");
                logger.error(e.getMessage());
                throw e;
        }
        return dentistList;
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
