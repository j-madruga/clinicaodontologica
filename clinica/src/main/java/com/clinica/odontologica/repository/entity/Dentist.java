package com.clinica.odontologica.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "DENTIST")
public class Dentist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id = null;

    @Column(name = "license")
    private String license;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    public Dentist(long id, String license, String name, String lastName) {
        this.id = id;
        this.license = license;
        this.name = name;
        this.lastName = lastName;
    }

    public Dentist(String license, String name, String lastName) {
        this.license = license;
        this.name = name;
        this.lastName = lastName;
    }

    public Dentist() {
    }

    @Override
    public String toString() {
        return "Dentist{" +
                "id=" + id +
                ", license='" + license + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

}
