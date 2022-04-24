package com.clinica.odontologica.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

     @Autowired
    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String passAdmin = passwordEncoder.encode("password");
        String passJosu = passwordEncoder.encode("password");

        if(!userRepository.findByEmail("admin@dh.com").isPresent() && !userRepository.findByEmail("josu@dh.com").isPresent()) {
            userRepository.save(new User("admin", "admin", "admin@dh.com", passAdmin, Role.ROLE_ADMIN));
            userRepository.save(new User("josue", "josu", "josu@dh.com", passJosu, Role.ROLE_USER));
        }
    }

}