/**
 * 
 */
package com.portfolio.management.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.portfolio.management.entity.User;

/**
 * @author Sarath
 *
 */

public interface UserService {
	
	public ResponseEntity<User> saveUser(User user);
	public ResponseEntity<List<User>> getAllUsers() ;
	public ResponseEntity<List<User>> findUserByFirstname(String firstName);
	public ResponseEntity<User> getUserById(long id);
	public ResponseEntity<User> deleteUserById(long id);
	public ResponseEntity<User> updateUser(User user, long id);

}
