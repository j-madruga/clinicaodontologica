package com.clinica.odontologica.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "ADDRESS")
public class Address {

    @Id
    @SequenceGenerator(name="address_sequence", sequenceName = "address_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "address_sequence")
    private Long id;
    @Column(name = "street")
    private String street;
    @Column(name = "street_number")
    private String streetNumber;
    @Column(name = "city")
    private String city;
    @Column(name = "province")
    private String province;

}
