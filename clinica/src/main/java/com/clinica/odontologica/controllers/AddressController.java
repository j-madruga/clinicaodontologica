package com.clinica.odontologica.controllers;

import com.clinica.odontologica.model.AddressDTO;
import com.clinica.odontologica.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
@CrossOrigin(origins = "*")
public class AddressController {

    @Autowired
    private AddressService addressService;

    /** prueba comit
     * Saves an address
     * POST: /address/save
     *
     * @param addressDTO an address object
     * @return json
     */
    @PostMapping("/save")
    public ResponseEntity<AddressDTO> saveAddress(@RequestBody AddressDTO addressDTO) {
        ResponseEntity<AddressDTO> response = ResponseEntity.internalServerError().build();
        if(addressDTO != null) {
            AddressDTO savedAddress = addressService.saveAddress(addressDTO);
            if (savedAddress.getId() != null) {
                response = ResponseEntity.ok(savedAddress);
            }
        }
        return response;
    }

    /**
     * Gets (if exists) an address by id
     * GET: /address/{id}
     *
     * @param id the id of the address to search
     * @return json
     */
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable Long id) {
        ResponseEntity<AddressDTO> response = ResponseEntity.notFound().build();
        AddressDTO addressDTO = addressService.getAddressById(id);
        if(addressDTO != null) {
            response = ResponseEntity.ok(addressDTO);
        }
        return response;
    }

}
