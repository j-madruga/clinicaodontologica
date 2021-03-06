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

    public Boolean saveAddressFromPatientDTO(PatientDTO patientDTO) {
        Boolean isAddressSaved = false;
        Address savedAddress = null;
        Address addressToSave = objectMapper.convertValue(patientDTO.getAddress(), Address.class);
        if (addressToSave != null) {
            savedAddress = iAddressRepository.save(addressToSave);
            if (savedAddress.getId() != null) {
                isAddressSaved = true;
            }
        }
        return isAddressSaved;
    }

    public AddressDTO getAddressById(Long id) {
        AddressDTO response = null;
        Optional<Address> address = iAddressRepository.findById(id);
        if (address.isPresent()) {
            response = objectMapper.convertValue(address.get(), AddressDTO.class);
        }
        return response;
    }
}
