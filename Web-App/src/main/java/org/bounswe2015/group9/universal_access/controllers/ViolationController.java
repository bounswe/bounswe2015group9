package org.bounswe2015.group9.universal_access.controllers;

import org.bounswe2015.group9.universal_access.dtos.ErrorDTO;
import org.bounswe2015.group9.universal_access.dtos.UserDTO;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.exceptions.RecordNotFoundException;
import org.bounswe2015.group9.universal_access.services.IViolationService;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * Created by umut on 01.12.2015.
 */
@RestController
@RequestMapping("/rest/violations")
public class ViolationController {

    @Autowired
    private IViolationService violationService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity<ViolationDTO> createViolation(OAuth2Authentication auth, @RequestBody ViolationDTO violationDTO){
        UserDTO gotUserDTO = new UserDTO((User) auth.getUserAuthentication().getPrincipal());
        ViolationDTO createdViolationDTO = violationService.createViolation(new User(gotUserDTO),violationDTO);
        return new ResponseEntity<ViolationDTO>(createdViolationDTO, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity getViolation(OAuth2Authentication auth, @PathVariable("id") Long id){
        ViolationDTO gotViolationDTO = null;
        try {
            gotViolationDTO = violationService.getViolation(id);
        }catch(RecordNotFoundException e) {
            return new ResponseEntity(new ErrorDTO(e.getMessage()), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<ViolationDTO>(gotViolationDTO,HttpStatus.OK);
    }


}
