package org.bounswe2015.group9.universal_access.controllers;

import org.bounswe2015.group9.universal_access.dtos.ErrorDTO;
import org.bounswe2015.group9.universal_access.dtos.RatingDTO;
import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.entities.Violation;
import org.bounswe2015.group9.universal_access.services.IRatingService;
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
            e.printStackTrace();
                return new ResponseEntity(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }

    //return new ResponseEntity<>(HttpStatus.CREATED);
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
            e.printStackTrace();
            return new ResponseEntity(new ErrorDTO(e.getMessage()),HttpStatus.BAD_REQUEST);
        }
    }

}
