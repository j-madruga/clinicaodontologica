package com.clinica.odontologica.repository.irepository;

import com.clinica.odontologica.repository.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface IAppointmentRepository extends JpaRepository<Appointment, Long> {
}
