package com.clinica.odontologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaApplication {
	private static final Logger LOGGER = LogManager.getLogger("com.log4j2.clinic");
	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
	}

}
