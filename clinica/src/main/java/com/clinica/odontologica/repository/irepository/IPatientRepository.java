package com.clinica.odontologica.repository.irepository;

import com.clinica.odontologica.repository.entity.Address;
import com.clinica.odontologica.repository.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IPatientRepository extends JpaRepository<Patient, Long> {
}
