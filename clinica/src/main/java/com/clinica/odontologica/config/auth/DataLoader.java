package com.clinica.odontologica.config.auth;

import com.clinica.odontologica.repository.entity.Role;
import com.clinica.odontologica.repository.entity.User;
import com.clinica.odontologica.repository.irepository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

     @Autowired
    private IUserRepository iUserRepository;

    @Autowired
    public DataLoader(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passAdmin = passwordEncoder.encode("password");
        String passJosu = passwordEncoder.encode("password");

        if(!iUserRepository.findByEmail("admin@dh.com").isPresent() && !iUserRepository.findByEmail("josu@dh.com").isPresent()) {
            iUserRepository.save(new User("admin", "admin", "admin@dh.com", passAdmin, Role.ROLE_ADMIN));
            iUserRepository.save(new User("josue", "josu", "josu@dh.com", passJosu, Role.ROLE_USER));
        }
    }

}