package org.bounswe2015.group9.universal_access.controllers;

import org.bounswe2015.group9.universal_access.dtos.ErrorDTO;
import org.bounswe2015.group9.universal_access.dtos.RatingDTO;
import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.entities.Violation;
<<<<<<< HEAD
import org.bounswe2015.group9.universal_access.exceptions.ForbiddenProccessException;
import org.bounswe2015.group9.universal_access.exceptions.RecordNotFoundException;
import org.bounswe2015.group9.universal_access.services.IRatingService;
import org.hibernate.exception.ConstraintViolationException;
=======
import org.bounswe2015.group9.universal_access.services.IRatingService;
>>>>>>> 06ae9e0fa8b18afb1f8d99ef1f7465e28be41fb9
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.*;

/**
 * Created by umut on 07.12.2015.
 */
@CrossOrigin
@RestController
@RequestMapping("/rest/rating")
public class RatingController {

    @Autowired
    private IRatingService ratingService;

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity setRating(OAuth2Authentication auth, @RequestBody RatingDTO ratingDTO, @PathVariable("id") Long id){
        User user = (User) auth.getUserAuthentication().getPrincipal();
        try {
            Violation violation = new Violation();
            violation.setId(id);
            ratingService.setRating(user, violation, ratingDTO);
            return new ResponseEntity(ratingDTO,HttpStatus.CREATED);
        }catch (RuntimeException e){
<<<<<<< HEAD
                return exceptionResponse(e);
        }
=======
            e.printStackTrace();
                return new ResponseEntity(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    //return new ResponseEntity<>(HttpStatus.CREATED);
>>>>>>> 06ae9e0fa8b18afb1f8d99ef1f7465e28be41fb9
    }
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity getRating(OAuth2Authentication auth,@PathVariable("id") Long id){
        User user = (User) auth.getUserAuthentication().getPrincipal();
        try {
            Violation violation = new Violation();
            violation.setId(id);
            RatingDTO ratingDTO = ratingService.getRating(user, violation);
            return new ResponseEntity(ratingDTO, HttpStatus.OK);
        }catch (RuntimeException e){
<<<<<<< HEAD
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
            e.printStackTrace();
            return new ResponseEntity(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
>>>>>>> 06ae9e0fa8b18afb1f8d99ef1f7465e28be41fb9
        }
    }

}
