package com.clinica.odontologica.repository.irepository;

import com.clinica.odontologica.repository.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAddressRepository extends JpaRepository<Address, Long> {
    @Query("from Patient p where p.id_address = :id_address")
    List<Address> getAddressByPatientId(@Param("id_address") Long idAddress);
    // TODO: cambiar los nombres de id de Patient, Address y Dentist

}
