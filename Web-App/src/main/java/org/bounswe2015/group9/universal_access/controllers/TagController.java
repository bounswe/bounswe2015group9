package org.bounswe2015.group9.universal_access.controllers;

import org.bounswe2015.group9.universal_access.dtos.ErrorDTO;
import org.bounswe2015.group9.universal_access.dtos.TagDTO;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.bounswe2015.group9.universal_access.entities.User;
<<<<<<< HEAD
import org.bounswe2015.group9.universal_access.exceptions.ForbiddenProccessException;
import org.bounswe2015.group9.universal_access.exceptions.RecordNotFoundException;
import org.bounswe2015.group9.universal_access.services.ITagService;
import org.hibernate.exception.ConstraintViolationException;
=======
import org.bounswe2015.group9.universal_access.services.ITagService;
>>>>>>> 06ae9e0fa8b18afb1f8d99ef1f7465e28be41fb9
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * Created by umut on 12.12.2015.
 */
@CrossOrigin
@RestController
@RequestMapping("/rest/tag")
public class TagController {
    @Autowired
    private ITagService tagService;

<<<<<<< HEAD
    @RequestMapping(value = "", method = RequestMethod.POST)
    public ResponseEntity createTag(OAuth2Authentication auth, @RequestBody TagDTO tagDTO){
        User user = (User) auth.getUserAuthentication().getPrincipal();
        try{
            tagService.createTag(tagDTO);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (RuntimeException e){
            return exceptionResponse(e);
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
=======
    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity createTag(OAuth2Authentication auth, @RequestBody TagDTO tagDTO,@PathVariable("id") Long id){
        User user = (User) auth.getUserAuthentication().getPrincipal();
        try{
            tagService.createTag(new ViolationDTO(id),tagDTO);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (RuntimeException e){
            e.printStackTrace();
            return new ResponseEntity(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
>>>>>>> 06ae9e0fa8b18afb1f8d99ef1f7465e28be41fb9
        }
    }
}
