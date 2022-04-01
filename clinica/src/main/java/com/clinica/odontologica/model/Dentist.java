package com.clinica.odontologica.model;

public class Dentist {
    private Long id = null;
    private String license;
    private String name;
    private String lastName;

    // Full constructor
    public Dentist(long id, String license, String name, String lastName) {
        this.id = id;
        this.license = license;
        this.name = name;
        this.lastName = lastName;
    }
    // Constructor without id
    public Dentist(String license, String name, String lastName) {
        this.license = license;
        this.name = name;
        this.lastName = lastName;
    }

    // Empty constructor
    public Dentist() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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
