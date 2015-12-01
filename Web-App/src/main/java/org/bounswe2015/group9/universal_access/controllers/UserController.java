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

import java.util.List;


@RestController
@RequestMapping("/rest/users")
public class UserController {


	@Autowired
	private IUserService userService;

	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
		User createdUser = userService.createUser(user);
		UserDTO createdUserDTO = new UserDTO(createdUser);
		return new ResponseEntity<UserDTO>(createdUserDTO, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUser(OAuth2Authentication auth, @PathVariable("id") Long id) {
		User gotUser = userService.getUser(id);
		gotUser.setPassword(null);
		UserDTO gotUserDTO = new UserDTO(gotUser);
		return new ResponseEntity<UserDTO>(gotUserDTO, HttpStatus.OK);
	}

	@RequestMapping(value = "/me", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> getUser(OAuth2Authentication auth) {
		UserDTO gotUserDTO = new UserDTO((User) auth.getUserAuthentication().getPrincipal());
		gotUserDTO.setPassword(null);
		return new ResponseEntity<UserDTO>(gotUserDTO, HttpStatus.OK);
	}
	@RequestMapping(value = "", method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> getAllUsers(){
		List<UserDTO> gotUsers = userService.getAllUserDTOs();
		return new ResponseEntity<List<UserDTO>>(gotUsers,HttpStatus.OK);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<UserDTO> updateUser(OAuth2Authentication auth, @PathVariable("id") Long id, @RequestBody UserDTO user) {
		User authenticatedUser = (User) auth.getUserAuthentication().getPrincipal();
		if (authenticatedUser.getId() != id) {
			return new ResponseEntity<UserDTO>(HttpStatus.FORBIDDEN);
		}
		user.setId(id);
		userService.updateUser(user);
		return new ResponseEntity<UserDTO>(user, HttpStatus.ACCEPTED);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public  ResponseEntity<UserDTO> deleteUser(OAuth2Authentication auth, @PathVariable("id") Long id){
		User authenticatedUser = (User) auth.getUserAuthentication().getPrincipal();
		if (authenticatedUser.getId() != id) {
			return new ResponseEntity<UserDTO>(HttpStatus.FORBIDDEN);
		}
		userService.deleteUser(id);
		return new ResponseEntity<UserDTO>(HttpStatus.ACCEPTED);
	}

}

