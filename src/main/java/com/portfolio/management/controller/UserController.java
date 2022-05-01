/**
 * 
 */
package com.portfolio.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.management.entity.User;
import com.portfolio.management.service.UserService;

/**
 * @author Sarath
 *
 */
@RestController
public class UserController {

	private UserService userService;

	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping(value = "/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return this.userService.getAllUsers();
	}

	@GetMapping(value = "/getUsers")
	public ResponseEntity<List<User>> getAllUsersByName(@RequestParam(name = "name") String firstName) {
		return this.userService.findUserByFirstname(firstName);
	}

	@GetMapping(value = "/getUser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) {
		return this.userService.getUserById(id);
	}

	@PutMapping(value="/user")
	public ResponseEntity<User> updateUserById(@RequestBody User user, @RequestParam(name = "id") long id) {
		return this.userService.updateUser(user, id);
	}
	
	@DeleteMapping(value = "/deleteUser")
	public ResponseEntity<User> deleteUserById(@RequestParam(name = "id") long id){
		return this.userService.deleteUserById(id);
	}

}
