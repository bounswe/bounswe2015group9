package org.bounswe2015.group9.universal_access.controllers;

import org.bounswe2015.group9.universal_access.entities.User;
import org.bounswe2015.group9.universal_access.dtos.UserDTO;
import org.bounswe2015.group9.universal_access.services.IUserService;
import org.bounswe2015.group9.universal_access.services.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
@RequestMapping("/user")
public class UserController {


	@Autowired
	private IUserService userService;

/*    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("id") long id) {
        System.out.println("Fetching User with id " + id);
        User user = userService.getUser(id);
        if (user == null) {
            System.out.println("User with id " + id + " not found");
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @RequestMapping("/{id}")
    @ResponseBody
    public String ping(@PathVariable("id") int id) {
        //User user = (User) auth.getUserAuthentication().getPrincipal();

        return "Hi "+id;
    }
	*/

    @ResponseBody 
	@RequestMapping(value = "/{userID}")
	public String createUser(@PathVariable long userID){
		User user = new User();
		user.setEmail("umut@gmail.com");
		userService.createUser(user);
		if(user==null){
			return "There is no user with the given ID!";
		}else{
			return "Success!";
		}				
	}


	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
		User createdUser = userService.createUser(user);
		UserDTO createdUserDTO = new UserDTO(createdUser);
		return new ResponseEntity<UserDTO>(createdUserDTO, HttpStatus.CREATED);
	}
}

