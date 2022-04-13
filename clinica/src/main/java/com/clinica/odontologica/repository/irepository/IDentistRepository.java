package com.clinica.odontologica.repository.irepository;

import com.clinica.odontologica.repository.entity.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IDentistRepository extends JpaRepository<Dentist, Long> {
//    @Query("FROM Dentist d WHERE d.license = ?1")
//    Optional<Dentist> findByLicense(String license);
}
