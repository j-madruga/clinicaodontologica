package com.clinica.odontologica.repository.irepository;

import com.clinica.odontologica.repository.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Integer> {
    List<Dentist> findByLicense(String license);
}
