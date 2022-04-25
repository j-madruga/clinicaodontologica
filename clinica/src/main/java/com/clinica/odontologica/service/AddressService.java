package com.clinica.odontologica.service;

import com.clinica.odontologica.model.AddressDTO;
import com.clinica.odontologica.model.PatientDTO;
import com.clinica.odontologica.repository.entity.Address;
import com.clinica.odontologica.repository.irepository.IAddressRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AddressService {
    @Autowired
    private IAddressRepository iAddressRepository;
    @Autowired
    private ObjectMapper objectMapper;

    public AddressDTO saveAddress(AddressDTO addressDTO) {
        Address addressToSave = objectMapper.convertValue(addressDTO, Address.class);
        Address savedAddress = iAddressRepository.save(addressToSave);
        return objectMapper.convertValue(savedAddress, AddressDTO.class);
    }


    public AddressDTO getAddressById(Long id) {
        AddressDTO response = null;
        Optional<Address> address = iAddressRepository.findById(id);
        if (address.isPresent()) {
            response = objectMapper.convertValue(address.get(), AddressDTO.class);
        }
        return response;
    }

    public Boolean updateAddressFromPatientDTO(PatientDTO patientDTO) {
        Boolean addressExists = false;
        Address addresToUpdate = objectMapper.convertValue(patientDTO.getAddress(), Address.class);
        Optional<Address> foundAddress = iAddressRepository.findById(addresToUpdate.getId());
        if (foundAddress.isPresent()) {
            Address updatedAddress = iAddressRepository.save(addresToUpdate);
        }
        return addressExists;
    }
}
