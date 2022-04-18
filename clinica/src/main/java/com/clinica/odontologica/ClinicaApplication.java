package com.clinica.odontologica;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Property;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClinicaApplication {
	private static final Logger LOGGER = LogManager.getLogger(ClinicaApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ClinicaApplication.class, args);
		LOGGER.info("Info level log message");
		LOGGER.debug("Debug level log message");
		LOGGER.error("Error level log message");
	}

}
