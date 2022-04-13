package com.clinica.odontologica.model;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DentistDTO {

    private Long id = null;
    private String license;
    private String name;
    private String lastName;

    public DentistDTO(Long id, String license, String name, String lastName) {
        this.id = id;
        this.license = license;
        this.name = name;
        this.lastName = lastName;
    }

    public DentistDTO(){

    }

}
