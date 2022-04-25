package com.clinica.odontologica.repository.irepository;

import com.clinica.odontologica.repository.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface IUserRepository extends JpaRepository<User, Long> {

    @Query
    Optional<User> findByEmail(String email);

}
