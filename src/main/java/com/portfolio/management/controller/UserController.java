/**
 * 
 */
package com.portfolio.management.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.management.entity.User;
import com.portfolio.management.entity.UserContact;
import com.portfolio.management.service.UserService;

/**
 * This RestController is responsible for all end-points related to user
 * management. It has currently end-points relating to entities {@link User},
 * {@link UserContact}
 * 
 * @since V0.1
 * 
 * @author Sarath
 *
 */
@RestController
public class UserController {

	private UserService userService;

	/**
	 * Constructor for the {@code UserController} with dependency injection.
	 * 
	 * @param {@link UserService}
	 */
	@Autowired
	public UserController(UserService userService) {
		this.userService = userService;
	}

	/**
	 * This end-point is used to save {@link User} via post request.
	 * 
	 * @param the request body has the {@link User} body as a json body.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the saved {@link User}.
	 */
	@PostMapping(value = "/user")
	public ResponseEntity<User> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
	}

	/**
	 * This end-point is used to fetch a list of {@link User} via get request.
	 * 
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the list of all {@link User}.
	 */
	@GetMapping(value = "/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		return this.userService.getAllUsers();
	}

	/**
	 * This end-point is used to get a list of {@link User} having a given
	 * first-name via post request.
	 * 
	 * @param as a request parameter the first-name of the {@link User}
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json a list of all {@link User} having the same first-name.
	 */
	@GetMapping(value = "/getUsers")
	public ResponseEntity<List<User>> getAllUsersByName(@RequestParam(name = "name") String firstName) {
		return this.userService.findUserByFirstname(firstName);
	}

	/**
	 * This end-point is used to get a {@link User} having a specific user-id via
	 * get request.
	 * 
	 * @param as path variable the user-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the {@link User} if present, else empty response with
	 *         HTTPStatus 204.
	 */
	@GetMapping(value = "/getUser/{id}")
	public ResponseEntity<User> getUserById(@PathVariable long id) {
		return this.userService.getUserById(id);
	}

	/**
	 * This end-point is used to modify an existing {@link User} via put request.
	 * 
	 * @param the request body has the {@link User} as a json and as Request
	 *            parameter the user-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the updated {@link User}.
	 */
	@PutMapping(value = "/user")
	public ResponseEntity<User> updateUserById(@RequestBody User user, @RequestParam(name = "id") long id) {
		return this.userService.updateUser(user, id);
	}

	/**
	 * This end-point is used to delete a {@link User} having a user-id via delete
	 * request.
	 * 
	 * @param the request param has the user-id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus}
	 *         204.
	 */
	@DeleteMapping(value = "/deleteUser")
	public ResponseEntity<User> deleteUserById(@RequestParam(name = "id") long id) {
		return this.userService.deleteUserById(id);
	}

	/**
	 * This end-point is used to get a list of all {@link UserContact} having a
	 * user-id via get request.
	 * 
	 * @param as request param the {@link User} id.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json list of all {@link UserContact} associated with that user-id.
	 */
	@GetMapping(value = "/getUserContacts")
	public ResponseEntity<Set<UserContact>> getUserContactsByUserId(@RequestParam(name = "id") long id) {
		return this.userService.getUserContactDetailsByUserId(id);
	}

	/**
	 * This end-point is used to get a {@link UserContact} corresponding to a
	 * particular id via get request.
	 * 
	 * @param as path variable the id for {@link UserContact}
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         as json the {@link UserContact} if it exists, else HttpStatus 204.
	 */
	@GetMapping(value = "/getUserContact/{id}")
	public ResponseEntity<UserContact> getUserContactById(@PathVariable(name = "id") long userContactId) {
		return this.userService.getUserContactDetailById(userContactId);
	}

	/**
	 * This end-point is used to update a {@link User} contact details via put
	 * request.
	 * 
	 * @param the request body has the set of {@link UserContact} as a json and the
	 *            user-id as request param.
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus} and
	 *         a json format of the updated {@link User}.
	 */
	@PutMapping(value = "/userContact")
	public ResponseEntity<User> saveUserContact(@RequestParam(name = "userId") long userId,
			@RequestBody Set<UserContact> userContactList) {
		return userService.UpdateUserContactByUserId(userContactList, userId);
	}

	/**
	 * This end-point is used to delete {@link UserContact} with particular id via
	 * delete request.
	 * 
	 * @param as request param the id for {@link UserContact}
	 * @return returns a {@link ResponseEntity} which has the {@link HttpStatus}
	 *         204.
	 */
	@DeleteMapping(value = "/deleteUserContact")
	public ResponseEntity<UserContact> deleteUserContactById(@RequestParam(name = "userContactId") long id) {
		return this.userService.deleteUserContactById(id);
	}

}
