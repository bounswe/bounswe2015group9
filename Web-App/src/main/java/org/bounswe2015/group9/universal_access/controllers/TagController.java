package org.bounswe2015.group9.universal_access.controllers;

import org.bounswe2015.group9.universal_access.dtos.ErrorDTO;
import org.bounswe2015.group9.universal_access.dtos.TagDTO;
import org.bounswe2015.group9.universal_access.dtos.ViolationDTO;
import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.services.ITagService;
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

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    public ResponseEntity createTag(OAuth2Authentication auth, @RequestBody TagDTO tagDTO,@PathVariable("id") Long id){
        User user = (User) auth.getUserAuthentication().getPrincipal();
        try{
            tagService.createTag(new ViolationDTO(id),tagDTO);
            return new ResponseEntity(HttpStatus.CREATED);
        }catch (RuntimeException e){
            e.printStackTrace();
            return new ResponseEntity(new ErrorDTO(e.getMessage()), HttpStatus.BAD_REQUEST);
        }
    }
}
