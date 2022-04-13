package com.clinica.odontologica.model;

import com.clinica.odontologica.repository.entity.Patient;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressDTO {
    private Long id;
    private String street;
    private String streetNumber;
    private String city;
    private String province;
}
