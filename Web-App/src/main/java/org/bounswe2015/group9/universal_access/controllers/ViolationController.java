package org.bounswe2015.group9.universal_access.controllers;

import org.bounswe2015.group9.universal_access.dtos.ErrorDTO;
import org.bounswe2015.group9.universal_access.dtos.UserDTO;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.exceptions.ForbiddenProccessException;
import org.bounswe2015.group9.universal_access.exceptions.RecordNotFoundException;
import org.bounswe2015.group9.universal_access.services.IViolationService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/rest/violations")
public class ViolationController {

    @Autowired
    private IViolationService violationService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity createViolation(OAuth2Authentication auth, @RequestBody ViolationDTO violationDTO){
        User user = (User) auth.getUserAuthentication().getPrincipal();
        try {
            ViolationDTO createdViolationDTO = violationService.createViolation(user, violationDTO);
            return new ResponseEntity<>(createdViolationDTO, HttpStatus.CREATED);
        } catch (RuntimeException e) {
            e.printStackTrace();
            if (e instanceof ConstraintViolationException) {
                return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    public ResponseEntity getViolation(OAuth2Authentication auth, @PathVariable("id") Long id){
        ViolationDTO gotViolationDTO = null;
        try {
            gotViolationDTO = violationService.getViolation(id);
            return new ResponseEntity<>(gotViolationDTO,HttpStatus.OK);
        }catch(RuntimeException e) {
            e.printStackTrace();
            if (e instanceof RecordNotFoundException) {
                return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.NOT_FOUND);
            } else {
                return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }
    }


    @RequestMapping(value = "",method = RequestMethod.GET)
    public ResponseEntity getViolations(OAuth2Authentication auth, @RequestParam Boolean closed) {
        try {
            List<ViolationDTO> violationDTOList = violationService.getViolations(closed);
            return new ResponseEntity<>(violationDTOList, HttpStatus.OK);
        } catch (RuntimeException e) {
            e.printStackTrace();
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private ResponseEntity exceptionResponse(RuntimeException e) {
        e.printStackTrace();
        if (e instanceof ConstraintViolationException || e instanceof IllegalArgumentException) {
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        } else if (e instanceof RecordNotFoundException) {
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.NOT_FOUND);
        } else if (e instanceof ForbiddenProccessException) {
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.FORBIDDEN);
        } else {
            return new ResponseEntity<>(new ErrorDTO(e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PATCH)
    public ResponseEntity patchViolation(OAuth2Authentication auth, @PathVariable("id") Long id, @RequestBody ViolationDTO violationDTO) {
        User user = (User) auth.getUserAuthentication().getPrincipal();
        violationDTO.setId(id);
        try {
            violationService.updatePatchViolation(user, violationDTO);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RuntimeException e) {
            return  exceptionResponse(e);
        }
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public ResponseEntity putViolation(OAuth2Authentication auth, @PathVariable("id") Long id, @RequestBody ViolationDTO violationDTO) {
        User user = (User) auth.getUserAuthentication().getPrincipal();
        violationDTO.setId(id);
        try {
            violationService.updatePutViolation(user, violationDTO);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RuntimeException e) {
            return  exceptionResponse(e);
        }
    }
}
