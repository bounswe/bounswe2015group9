package org.bounswe2015.group9.universal_access.controllers;

import org.bounswe2015.group9.universal_access.dtos.UserDTO;
import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by umut on 25.11.2015.
 */
@RestController
@RequestMapping("/users")
public class UserNonSecureController {
    @Autowired
    private IUserService userService;

    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        User createdUser = userService.createUser(user);
        UserDTO createdUserDTO = new UserDTO(createdUser);
        return new ResponseEntity<UserDTO>(createdUserDTO, HttpStatus.CREATED);
    }
    @RequestMapping(value = "/getUser", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> getUser(@RequestBody UserDTO user) {
        User gotUser = userService.getUser(user.getId());
        UserDTO gotUserDTO = new UserDTO(gotUser);
        return new ResponseEntity<UserDTO>(gotUserDTO, HttpStatus.OK);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO user) {
        userService.updateUser(user);
        return new ResponseEntity<UserDTO>(user, HttpStatus.ACCEPTED);
    }
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public ResponseEntity<UserDTO> deleteUser(@RequestBody UserDTO user) {
        userService.deleteUser(user.getId());
        return new ResponseEntity<UserDTO>(HttpStatus.ACCEPTED);
    }

}
