/**
 * 
 */
package com.portfolio.management.service;

import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.portfolio.management.entity.User;
import com.portfolio.management.entity.UserContact;

/**
 * Service interface for all transactions relating to a {@link User}.
 * 
 * @author Sarath
 * @since 0.1
 *
 */

public interface UserService {

	/**
	 * The service method to save a {@link User} to the db.
	 * 
	 * @param {@link User} object.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and saved entity
	 *         {@link User}.
	 */
	public ResponseEntity<User> saveUser(User user);

	/**
	 * The service method to get all {@link User} from the db.
	 * 
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and list of all
	 *         {@link User} entities.
	 */
	public ResponseEntity<List<User>> getAllUsers();

	/**
	 * The service method to search the db for a {@link User} having given
	 * firstName.
	 * 
	 * @param firstName to be searched.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and entity
	 *         {@link User} matching the given firstName or empty.
	 */
	public ResponseEntity<List<User>> findUserByFirstname(String firstName);

	/**
	 * The service method to get a {@link User} from the db having particular
	 * user-id.
	 * 
	 * @param user-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and saved entity
	 *         {@link User} having particular user-id or {@link HttpStatus} 204.
	 */
	public ResponseEntity<User> getUserById(long id);

	/**
	 * The service method to delete if found, a {@link User} with given user-id.
	 * 
	 * @param user-id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 204.
	 */
	public ResponseEntity<User> deleteUserById(long id);

	/**
	 * The service method to update a {@link User} in the db.
	 * 
	 * @param {@link User} object.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 202 and updated
	 *         entity {@link User} or else {@link HttpStatus} 304.
	 */
	public ResponseEntity<User> updateUser(User user, long id);

	/**
	 * The service method to get a list of {@link UserContact} from the db matching
	 * a user-id.
	 * 
	 * @param user-id of {@link User}
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and list of all
	 *         {@link UserContact} entities found or else {@link HttpStatus} 204.
	 */
	public ResponseEntity<Set<UserContact>> getUserContactDetailsByUserId(long userId);

	/**
	 * The service method to get a {@link UserContact} from the db having a
	 * particular id.
	 * 
	 * @param {@link UserContact} id.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 302 and saved entity
	 *         {@link UserContact} if entries are found else {@link HttpStatus} 204.
	 */
	public ResponseEntity<UserContact> getUserContactDetailById(long userContactId);

	/**
	 * The service method to update a {@link User}s contact details.
	 * 
	 * @param {@link UserContact} object and id for {@link User}
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 200 and updated
	 *         entity {@link User} or else {@link HttpStatus} 304.
	 */
	public ResponseEntity<User> UpdateUserContactByUserId(Set<UserContact> userContactList, long userId);

	/**
	 * The service method to delete a {@link UserContact} to the db.
	 * 
	 * @param {@link UserContact} id to be deleted.
	 * @return a {@link ResponseEntity} with {@link HttpStatus} 204.
	 */
	public ResponseEntity<UserContact> deleteUserContactById(long userContactId);

}
